package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.common.JDBCUtil;
import model.vo.BoardSet;
import model.vo.BoardVO;
import model.vo.ReplyVO;

// 오라클 버전으로 바꿔보기 꼭!!!!!!!!!!!!!!!!!!!!!!!!!!
public class BoardDAO { // BoardSet을 다루는 DAO클래스
	Connection conn;
	PreparedStatement pstmt;

	static final String insert_board="insert into board (bid,mid,content) values((select nvl(max(bid),0)+1 from board),?,?)";
	static final String insert_reply="insert into reply (rid,bid,mid,msg) values((select nvl(max(rid),0)+1 from reply),?,?,?)";
	static final String delete_board="delete from board where bid=?";
	static final String delete_reply="delete from reply where rid=?";
	static final String update="update board set favcnt=favcnt+1 where bid=?";
	static final String selectAll_board="select * from (select * from board order by bid desc) where rownum<=?"; // 내림차순 정렬, 페이징처리 pagination
	static final String selectAll_board2="select * from (select * from board order by bid desc) where rownum<=? and mid=?"; // 내림차순 정렬, 페이징처리 pagination
	// select * from (select * from board order by bid desc) where rownum<=?;
	// select * from board where rownum<=? order by bid desc
	// 오라클 에서는 rownum으로 대체하여 sql작성★
	static final String selectAll_reply="select * from reply where bid=? order by rid desc";
	// 글 작성 C
	public boolean insertBoard(BoardVO vo) {
		conn = JDBCUtil.connect();
		try {
			pstmt=conn.prepareStatement(insert_board);
			pstmt.setString(1, vo.getMid());
			pstmt.setString(2, vo.getContent());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		JDBCUtil.disconnect(pstmt, conn);
		return true;
	}
	// 댓글 작성 C
	public boolean insertReply(ReplyVO vo) {
		conn = JDBCUtil.connect();
		try {
			pstmt=conn.prepareStatement(insert_reply);
			pstmt.setInt(1, vo.getBid());
			pstmt.setString(2, vo.getMid());
			pstmt.setString(3, vo.getMsg());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		JDBCUtil.disconnect(pstmt, conn);
		return true;
	}
	// 글 삭제 D
	public boolean deleteBoard(BoardVO vo) {
		conn = JDBCUtil.connect();
		try {
			pstmt=conn.prepareStatement(delete_board);
			pstmt.setInt(1, vo.getBid());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		JDBCUtil.disconnect(pstmt, conn);
		return true;
	}
	// 댓글 삭제 D
	public boolean deleteReply(ReplyVO vo) {
		conn = JDBCUtil.connect();
		try {
			pstmt=conn.prepareStatement(delete_reply);
			pstmt.setInt(1, vo.getRid());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		JDBCUtil.disconnect(pstmt, conn);
		return true;
	}
	// 좋아요 ☆
	public boolean update(BoardVO vo) {
		conn=JDBCUtil.connect();
		try {
			pstmt=conn.prepareStatement(update);
			pstmt.setInt(1, vo.getBid());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		JDBCUtil.disconnect(pstmt, conn);
		return true;
	}

	// 전체 글+댓글 출력 ☆ R
	public ArrayList<BoardSet> selectAll(BoardVO vo, int cnt){
		ArrayList<BoardSet> datas=new ArrayList<BoardSet>();
		conn = JDBCUtil.connect();
		try {
			
			if(vo.getMid()==null || vo.getMid().equals("")){ // 기존 비즈니스메서드에 분기점 추가
				// if(vo.getMid().equals("") || vo.getMid()==null){ 이렇게 쓰면 null일 때 equals를 못해서 오류가 뜸.
				System.out.println("로그: 글 목록 보기");
				pstmt=conn.prepareStatement(selectAll_board);
				pstmt.setInt(1, cnt);
			}else {
				System.out.println("로그: 특정인이 작성한 글 보기");
				pstmt=conn.prepareStatement(selectAll_board2);
				pstmt.setInt(1, cnt);
				pstmt.setString(2, vo.getMid());
				
			}
			
			ResultSet rs= pstmt.executeQuery();
			while(rs.next()){
				BoardSet bs = new BoardSet();

				BoardVO boardVO = new BoardVO();
				boardVO.setBdate(rs.getString("bdate"));
				boardVO.setBid(rs.getInt("bid"));
				boardVO.setContent(rs.getString("content"));
				boardVO.setFavcnt(rs.getInt("favcnt"));
				boardVO.setMid(rs.getString("mid"));
				boardVO.setRpcnt(rs.getInt("rpcnt"));
				bs.setBoardVO(boardVO);

				ArrayList<ReplyVO> replyList=new ArrayList<ReplyVO>();
				pstmt=conn.prepareStatement(selectAll_reply);
				pstmt.setInt(1, rs.getInt("bid"));
				ResultSet rs2 = pstmt.executeQuery();
				while(rs2.next()) {
					ReplyVO replyVO = new ReplyVO();
					replyVO.setBid(rs2.getInt("bid"));
					replyVO.setMid(rs2.getString("mid"));
					replyVO.setMsg(rs2.getString("msg"));
					replyVO.setRdate(rs2.getString("rdate"));
					replyVO.setRid(rs2.getInt("rid"));
					replyList.add(replyVO);
				}
				rs2.close();
				bs.setReplyList(replyList);

				datas.add(bs);
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		JDBCUtil.disconnect(pstmt, conn);
		return datas;
	}

}
