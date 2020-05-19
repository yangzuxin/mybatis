package com.xiaoan.json;

public class Util {
	private String title;// 标题
	private String coverpic;// 图片地址
	private String createtime;// 时间
	private String play_url;// 播放地址
	private String yearname;// 影片时间
	private String httpurl;//m3u8;
	private String httpurl_preview;//m3u8
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCoverpic() {
		return coverpic;
	}
	public void setCoverpic(String coverpic) {
		this.coverpic = coverpic;
	}
	public String getCreatetime() {
		return createtime;
	}
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}
	public String getPlay_url() {
		return play_url;
	}
	public void setPlay_url(String play_url) {
		this.play_url = play_url;
	}
	public String getYearname() {
		return yearname;
	}
	public void setYearname(String yearname) {
		this.yearname = yearname;
	}
	public String getHttpurl() {
		return httpurl;
	}
	public void setHttpurl(String httpurl) {
		this.httpurl = httpurl;
	}
	public String getHttpurl_preview() {
		return httpurl_preview;
	}
	public void setHttpurl_preview(String httpurl_preview) {
		this.httpurl_preview = httpurl_preview;
	}
	@Override
	public String toString() {
		return "user [title=" + title + ", coverpic=" + coverpic + ", createtime=" + createtime + ", play_url="
				+ play_url + ", yearname=" + yearname + ", httpurl=" + httpurl + ", httpurl_preview=" + httpurl_preview
				+ "]";
	}
	
	
}
