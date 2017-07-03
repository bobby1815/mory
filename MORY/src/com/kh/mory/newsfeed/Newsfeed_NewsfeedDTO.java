package com.kh.mory.newsfeed;

/*===============================================

	화면명 : Newsfeed_NewsfeedDTO.java
	화면설명 : 뉴스피드 사용자 정의 자료형 클래스

===============================================*/

public class Newsfeed_NewsfeedDTO
{
	// 주요 속성 구성
	private String whrite_seq, write_user_id, page_code, write_cont, write_reg_dtm, feed_seq, feed_love_cnt;

	private String uplo_seq, write_seq, uplo_loca;
	
	private String user_nic;
	// 댓글
	private String comment_seq, comment_cont, comment_reg_dtm;
	// 답글
	private String recomment_seq, recomment_cont, recomment_reg_dtm;
	// 추가
	private String user_id, requ_user_id;
	
	
	public String getRequ_user_id()
	{
		return requ_user_id;
	}

	public void setRequ_user_id(String requ_user_id)
	{
		this.requ_user_id = requ_user_id;
	}

	public String getUser_id()
	{
		return user_id;
	}

	public void setUser_id(String user_id)
	{
		this.user_id = user_id;
	}

	public String getComment_seq()
	{
		return comment_seq;
	}

	public void setComment_seq(String comment_seq)
	{
		this.comment_seq = comment_seq;
	}

	public String getComment_cont()
	{
		return comment_cont;
	}

	public void setComment_cont(String comment_cont)
	{
		this.comment_cont = comment_cont;
	}

	public String getComment_reg_dtm()
	{
		return comment_reg_dtm;
	}

	public void setComment_reg_dtm(String comment_reg_dtm)
	{
		this.comment_reg_dtm = comment_reg_dtm;
	}

	public String getRecomment_seq()
	{
		return recomment_seq;
	}

	public void setRecomment_seq(String recomment_seq)
	{
		this.recomment_seq = recomment_seq;
	}

	public String getRecomment_cont()
	{
		return recomment_cont;
	}

	public void setRecomment_cont(String recomment_cont)
	{
		this.recomment_cont = recomment_cont;
	}

	public String getRecomment_reg_dtm()
	{
		return recomment_reg_dtm;
	}

	public void setRecomment_reg_dtm(String recomment_reg_dtm)
	{
		this.recomment_reg_dtm = recomment_reg_dtm;
	}

	public String getUser_nic()
	{
		return user_nic;
	}

	public void setUser_nic(String user_nic)
	{
		this.user_nic = user_nic;
	}

	// getter / setter 구성
	public String getWhrite_seq()
	{
		return whrite_seq;
	}

	public void setWhrite_seq(String whrite_seq)
	{
		this.whrite_seq = whrite_seq;
	}

	public String getWrite_user_id()
	{
		return write_user_id;
	}

	public void setWrite_user_id(String write_user_id)
	{
		this.write_user_id = write_user_id;
	}

	public String getPage_code()
	{
		return page_code;
	}

	public void setPage_code(String page_code)
	{
		this.page_code = page_code;
	}

	public String getWrite_cont()
	{
		return write_cont;
	}

	public void setWrite_cont(String write_cont)
	{
		this.write_cont = write_cont;
	}

	public String getWrite_reg_dtm()
	{
		return write_reg_dtm;
	}

	public void setWrite_reg_dtm(String write_reg_dtm)
	{
		this.write_reg_dtm = write_reg_dtm;
	}

	public String getFeed_seq()
	{
		return feed_seq;
	}

	public void setFeed_seq(String feed_seq)
	{
		this.feed_seq = feed_seq;
	}

	public String getFeed_love_cnt()
	{
		return feed_love_cnt;
	}

	public void setFeed_love_cnt(String feed_love_cnt)
	{
		this.feed_love_cnt = feed_love_cnt;
	}
	
	// getter / setter 구성
	public String getUplo_seq()
	{
		return uplo_seq;
	}

	public void setUplo_seq(String uplo_seq)
	{
		this.uplo_seq = uplo_seq;
	}

	public String getWrite_seq()
	{
		return write_seq;
	}

	public void setWrite_seq(String write_seq)
	{
		this.write_seq = write_seq;
	}

	public String getUplo_loca()
	{
		return uplo_loca;
	}

	public void setUplo_loca(String uplo_loca)
	{
		this.uplo_loca = uplo_loca;
	}
}
