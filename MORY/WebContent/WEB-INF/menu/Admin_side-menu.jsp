<%@ page  contentType="text/html; charset=UTF-8" %>
<!-- 사이드 메뉴 start -->
        <div class="col-xs-12 col-md-3 text-center">
            <h2><label class="label label-success">관리자 환경설정</label></h2>
            <div class="col-xs-10 col-xs-offset-1 text-center">

                <div class="drop-menu-top">
                    <h4 style="margin:0px; padding:13px 0px;">관리자 메뉴</h4>
                </div>

                <a href="#mem" data-toggle="collapse">
                    <div class="drop-menu "><h4>계정관리</h4></div>
                </a>
                <div id="mem" class="collapse in ">
                    <a href="userlist.do">
                        <div class="drop-menu">
                        	<h5>└ 계정조회</h5>
                        </div>
                    </a>
                    <a href="declarationnewspeeduserlist.do">
                        <div class="drop-menu">
                            <h5>└ 신고 목록조회</h5>
                        </div>
                    </a>
                    <a href="detailnewspeeduserlist.do">
                        <div class="drop-menu">
                            <h5>└ 신고 상세조회</h5>
                        </div>
                    </a>
                </div>

                <a href="#cus" data-toggle="collapse">
                    <div class="drop-menu"><h4>고객센터</h4></div>
                </a>
                <div id="cus" class="collapse">
                    <a href="bliduser.do">
                        <div class="drop-menu">
                            <h5>└ 블라인드 조회</h5>
                        </div>
                    </a>
                    <a href="question.do">
                        <div class="drop-menu">
                            <h5>└ 1:1문의 목록</h5>
                        </div>
                    </a>
                </div>

                <a href="#com" data-toggle="collapse">
                    <div class="drop-menu"><h4>커뮤니티 관리</h4></div>
                </a>
                <div id="com" class="collapse">
                    <a href="communitylist.do">
                        <div class="drop-menu">
                            <h5>└ 커뮤니티 관리</h5>
                        </div>
                    </a>
                </div>

                <a href="#sys" data-toggle="collapse">
                    <div class="drop-menu"><h4>시스템환경설정</h4></div>
                </a>
                <div id="sys" class="collapse">
                    <a href="system.do">
                        <div class="drop-menu">
                            <h5>└ 시스템환경설정</h5>
                        </div>
                    </a>
                </div>

            </div>
        </div>
        <!-- 사이드 메뉴 end -->