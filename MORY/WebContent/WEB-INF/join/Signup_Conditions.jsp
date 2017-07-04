<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Conditions.jsp</title>
<!-- jQuery -->
<script type="text/javascript" src="http://code.jquery.com/jquery-1.10.2.js"></script>
<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" 	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<!-- 부가적인 테마 -->
<link rel="stylesheet" 	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="css/Mainmenu.css" />

<style type="text/css">
div 
{
}

.btn 
{
	height: 50px;
	width: 100px;
}
#nextBtn{font-weight: bold; font-size: 20px;}
#nextBtn:HOVER
{
	color: green;
}
#preBtn{font-weight: bold; font-size: 20px;}
#preBtn:HOVER{color: orange;}

textarea 
{
	margin-bottom: 10px;
}
</style>

<!-- jQuery 영역 -->
<script type="text/javascript">

	$(document).ready(function()
	{
		$("#nextBtn").click(function()
		{
			//alert($("#chk1").is(":checked"));
			if ($("#chk1").is(":checked")==false || $("#chk2").is(":checked")==false || $("#chk3").is(":checked")==false)
			{
				alert("모든 약관에 동의하셔야 합니다.");
				return false;
			}
			
			$(location).attr("href","joinformprocess.do");
			
		});
	});

</script>


</head>
<body>



	<div class="container" id="container">
		<!-- 첫번째 row  -->
		<header>
			<!-- 첫번째 row  -->
			<div class="row " id="all0">
				<div class="col-xs-1 col-md-1" id="h1"></div>
				<div class="col-xs-10 col-md-10  text-center"
					style="margin-bottom: 30px;" id="h2">
					<h1>
						<img alt="error" src="img/mainimage.png" style="width: 80px;"><img src="img/Mainmory.png" width="100" />
					</h1>
				</div>
				<div class="col-xs-1 col-md-1" id="h3"></div>
			</div>
		</header>
		<!-- 	두번째 row  -->
		<div class="row " id="all1">
			<div class="col-xs-1 col-md-1" id="b1"></div>
			<div class="col-xs-10 col-md-10" id="b2">
				<!-- 1번째 area -->
				<div class="row text-center">
					<textarea rows="6" cols="75" style="overflow:scroll;">
					MORY 서비스 약관	

MORY에 오신 것을 환영합니다.

MORY 제품 및 서비스(‘서비스’)를 이용해 주셔서 감사합니다. 서비스는 서울특별시 영등포구 양평동4가 2 KH Academey 에 소재한 MORY Inc.(‘MORY’)에서 제공합니다.

서비스를 이용함으로써 귀하는 본 약관에 동의하게 되므로 본 약관을 주의 깊게 읽어보시기 바랍니다.

MORY 서비스는 매우 다양하므로 때로 추가약관 또는 제품 요구사항(연령 요건 포함)이 적용될 수 있습니다. 추가약관은 관련 서비스에 대하여 제공되며, 귀하가 해당 서비스를 이용하는 경우 이 추가약관은 귀하와 MORY 간 계약의 일부가 됩니다.

MORY 서비스 이용

귀하는 서비스 내에서 적용되는 모든 정책을 준수해야 합니다.

MORY 서비스의 오용을 삼가시기 바랍니다. 예를 들어 서비스를 방해하거나 MORY이 제공하는 인터페이스 및 안내사항 이외의 다른 방법을 사용하여 액세스를 시도하지 않아야 합니다. 귀하는 관련 수출 및 재수출 통제 법규 및 규정 등 오직 법률상 허용되는 범위에서만 MORY 서비스를 이용할 수 있습니다. 귀하가 MORY 약관이나 정책을 준수하지 않거나 MORY이 부정행위 혐의를 조사하고 있는 경우, MORY 서비스 제공이 일시 중지 또는 중단될 수 있습니다.

MORY 서비스를 사용한다고 해서 MORY 서비스 또는 액세스하는 콘텐츠의 지적재산권을 소유하게 되는 것은 아닙니다. 콘텐츠 소유자로부터 허가를 받거나 달리 법률에 따라 허용되는 경우를 제외하고, MORY 서비스의 콘텐츠를 사용할 수 없습니다. 본 약관은 귀하에게 MORY 서비스에 사용된 브랜드나 로고를 사용할 권리를 부여하지 않습니다. MORY 서비스에 또는 MORY 서비스와 함께 게재된 어떠한 법적 고지도 삭제하거나 감추거나 변경하지 마십시오.

MORY 서비스는 MORY이 소유하지 않은 일부 콘텐츠를 표시할 수 있습니다. 그러한 콘텐츠에 대해서는 제공한 주체가 단독으로 책임지게 됩니다. MORY은 콘텐츠의 위법성 여부 또는 MORY 정책 위반 여부를 결정하기 위해 검토할 수 있으며, 콘텐츠가 MORY 정책 또는 법률에 위반된다고 합리적으로 판단하는 경우 이를 삭제하거나 게시를 거부할 수 있습니다. 그렇다고 반드시 콘텐츠를 검토한다는 의미는 아니므로, 콘텐츠를 검토할 것이라고 간주하지 마십시오.

서비스 이용과 관련하여 MORY은 귀하에게 서비스 고지, 관리 메시지 및 기타 정보를 발송할 수 있습니다. 귀하는 메시지 수신을 거부할 수 있습니다.

일부 MORY 서비스는 휴대기기에서 사용할 수 있습니다. 트래픽 또는 보안 관련 법규 준수를 방해하거나 막는 방식으로 서비스를 사용해서는 안 됩니다.
귀하의 MORY 계정

귀하가 MORY 서비스를 이용하기 위해서는 MORY 계정이 필요할 수 있습니다. 귀하가 MORY 계정을 직접 만들 수도 있고, 고용주 또는 교육기관과 같은 관리자가 귀하에게 MORY 계정을 배정할 수도 있습니다. 관리자가 배정한 MORY 계정을 사용하고 있는 경우, 별도의 약관 또는 추가약관이 적용될 수 있으며 관리자가 귀하의 계정에 액세스하거나 계정을 해지할 수 있습니다.

MORY 계정을 보호하려면 비밀번호를 비공개로 유지하십시오. 귀하는 MORY 계정에서 또는 MORY 계정을 통해 이루어지는 활동에 대한 책임이 있습니다. 타사 애플리케이션에서 MORY 계정 비밀번호를 재사용하지 마십시오. 귀하의 비밀번호나 MORY 계정이 무단으로 사용되고 있음을 알게 되는 경우 다음 도움말을 참조하시기 바랍니다.</textarea>
				</div>
				<div class="col-md-2" style="margin-right: 40px;"></div>
				<div class="row   col-md-6">
					<input type="checkbox" id="chk1"><label for="chk1">위 약관을 확인 하였고 동의합니다.</label>
				</div>

				<!-- 2번째 area -->
				<div class="row  text-center">
					<textarea rows="6" cols="75" style="overflow:scroll;">
개인정보 보호 및 저작권 보호

MORY 개인정보처리방침은 귀하가 MORY 서비스를 사용할 때 MORY이 개인정보를 어떻게 취급하고 보호하는지에 대해 설명합니다. MORY 서비스를 사용함으로써 귀하는 MORY이 개인정보처리방침에 따라 귀하의 개인정보를 사용할 수 있음에 동의하게 됩니다.

MORY은 미국 디지털 밀레니엄 저작권법(US Digital Millennium Copyright Act)에 규정된 절차에 따라 저작권침해를 주장하는 신고에 대응하고, 반복 침해자의 계정을 해지합니다.

MORY은 저작권자가 온라인상에서 자신의 지적 재산을 관리할 수 있도록 정보를 제공합니다. 누군가 귀하의 저작권을 침해하고 있다고 생각되어 MORY에 통지하고자 하는 경우, MORY 도움말 센터에서 신고서 제출 방법 및 저작권 침해 신고에 대한 MORY 대응 정책 관련 정보를 확인하실 수 있습니다.

MORY 서비스에 포함된 귀하의 콘텐츠

귀하는 일부 MORY 서비스에서 콘텐츠를 업로드, 제출, 저장, 전송, 수신할 수 있으며 이에 대해 귀하가 보유한 지적재산권은 귀하의 소유입니다. 즉, 귀하가 보유한 권리는 귀하에게 존속됩니다.

귀하가 콘텐츠를 MORY 서비스로 또는 이를 통해 업로드, 제출, 저장, 전송 또는 수신하는 경우 귀하는 MORY(및 MORY의 협력사)이 이러한 콘텐츠를 사용, 저장, 복제, 수정, 이차적 저작물(귀하의 콘텐츠가 MORY 서비스와 더 잘 작동하도록 MORY이 생성하는 번역본, 개작본, 또는 수정본으로 인해 발생되는 것) 제작, 전달, 공개, 공개적으로 실연, 공개적으로 게시 및 배포할 수 있는 전 세계적인 라이선스를 제공하게 됩니다. 본 라이선스에서 귀하가 부여하는 권리는 MORY 서비스를 운영, 홍보 및 개선하고 새로운 서비스를 개발하기 위한 제한적인 목적으로 사용됩니다. 본 라이선스는 귀하가 MORY 서비스의 사용을 중지한 후에도 존속됩니다(예: MORY 지도에 추가한 업체 정보). 일부 서비스에서는 제공한 콘텐츠에 액세스하고 이를 삭제하는 방법을 제공할 수 있습니다. 또한 서비스 중 일부에는 제출된 콘텐츠에 대한 MORY의 사용 범위를 제한하는 약관 또는 설정이 있습니다. 귀하는 MORY 서비스에 제출한 콘텐츠에 대해 MORY에 라이선스를 부여하기 위해 필요한 권리를 보유해야 합니다.

MORY의 자동 시스템은 맞춤 검색결과, 맞춤 광고, 스팸/멀웨어 감지 등 귀하에게 유용한 제품 기능을 제공할 목적으로 귀하의 콘텐츠(이메일 포함)를 분석합니다. 이러한 분석은 콘텐츠 전송, 수신, 저장 시에 수행됩니다.

귀하가 MORY 계정을 사용하는 경우 MORY은 귀하의 프로필 이름, 프로필 사진 및 MORY 또는 MORY 계정에 연결된 타사 애플리케이션에서 수행하는 작업(예: +1, 리뷰, 댓글 등)을 MORY 서비스에 표시할 수 있습니다(광고 및 기타 상업적 용도로 표시하는 경우 포함). MORY은 MORY 계정에서 공유 또는 공개 설정을 제한하는 귀하의 선택을 존중합니다. 예를 들어, 귀하의 이름과 사진이 광고에 표시되지 않도록 설정할 수 있습니다.

MORY이 콘텐츠를 사용 및 저장하는 방법에 대해 좀 더 자세한 정보가 필요한 경우, MORY 개인정보처리방침 또는 특정 서비스에 대한 추가약관을 참조하시기 바랍니다. 귀하가 MORY 서비스에 대한 의견이나 제안을 제출하는 경우 MORY은 귀하에 대한 의무 없이 귀하의 의견이나 제안을 사용할 수 있습니다.
</textarea>
				</div>
				<div class="col-md-2" style="margin-right: 40px;"></div>
				<div class="row col-md-6" >
					<input type="checkbox" id="chk2"><label for="chk2">위 약관을 확인 하였고 동의합니다.</label>
				</div>

				<!-- 3번째 area -->
				<div class="row  text-center">
					<textarea rows="6" cols="75" style="overflow:scroll;">
MORY 서비스의 수정 및 해지

MORY은 서비스를 지속적으로 변경 및 개선하고 있습니다. MORY은 기능을 추가 또는 제거할 수 있으며, 서비스를 일시 중지하거나 완전히 중단할 수 있습니다.

MORY로서는 매우 안타까운 일이지만, 귀하는 언제라도 MORY 서비스 이용을 중지할 수 있습니다. MORY 또한 언제든지 서비스 제공을 중단하거나 MORY 서비스에 대해 새로운 제한을 추가하거나 만들 수 있습니다.

귀하의 데이터는 귀하 소유이며, 이러한 데이터에 계속 액세스하도록 하는 것이 매우 중요하다고 MORY은 믿고 있습니다. MORY은 서비스를 중지할 때 합리적으로 가능한 경우 귀하에게 합당한 사전 통지를 제공하고 귀하가 해당 서비스에서 정보를 반출할 기회를 제공할 것입니다.

MORY의 보증 및 부인

MORY은 상업적으로 합리적인 수준의 기술을 사용하고 주의를 기울여 서비스를 제공하며, 귀하가 서비스를 누리게 되길 바랍니다. 단, 서비스에 대하여 약속할 수 없는 몇 가지 사항이 있습니다.

본 약관 또는 추가약관에 명시되지 않은 한 MORY, 또는 MORY의 공급자나 판매자는 서비스와 관련하여 어떠한 구체적인 약정도 하지 않습니다. 예를 들어, MORY은 서비스에 속한 콘텐츠, 서비스의 특정 기능, 서비스의 신뢰성, 이용가능성 또는 귀하의 요구를 충족할 능력에 대하여 어떠한 약정도 하지 않습니다. MORY은 서비스를 ‘있는 그대로’ 제공합니다.

일부 사법관할권 내에서는 상품성, 특정목적에의 적합성 및 비침해성에 대한 묵시적 보증과 같은 특정 보증이 인정됩니다. MORY은 법률상 허용되는 한도 내에서 모든 보증을 배제합니다.

MORY 서비스에 대한 책임

법률상 허용되는 경우, MORY, MORY의 공급자 및 판매자는 일실이익, 일실수입, 망실자료, 재무적 손실, 간접 손해, 특별 손해, 결과적 손해, 징계적 손해, 또는 징벌적 손해에 대해 책임지지 않습니다.

법률상 허용되는 한도 내에서, 묵시적 보증을 포함하여 본 약관에 따른 청구에 대한 MORY, MORY의 공급자 및 판매자의 총 책임은 귀하가 서비스 사용을 위해 MORY에 지급한 금원(또는 MORY의 선택에 따라 귀하에게 서비스를 다시 제공하는 것)으로 제한됩니다.

어떤 경우에도 MORY, MORY의 공급자 및 판매자는 합리적으로 예측 불가능한 손실이나 손해에 대해 책임지지 않습니다.

일부 국가에서는 귀하에게 소비자로서의 법적 권리가 부여된다는 것을 MORY은 알고 있습니다. 개인적인 목적으로 서비스를 사용 중인 경우에는 본 약관이나 추가약관의 어떤 규정도 계약에 의해 철회될 수 없는 법적 소비자 권리를 제한할 수 없습니다.

업체의 MORY 서비스 사용

업체를 대신하여 MORY 서비스를 사용하는 경우 다음 약관이 적용됩니다. 서비스 이용 또는 해당 약관 위반으로 인해 발생하거나 이와 관련된 모든 소송, 고소 또는 조치로부터 MORY과 MORY의 제휴사, 임원, 대행사 및 직원을 보호하고 면책해야 하며 여기에는 각종 책임과 소송, 손실, 피해, 고소, 판결, 소송 비용 및 변호사 수임료 등으로 인한 비용도 포함됩니다.

본 약관에 대하여

MORY은 법률의 변경이나 서비스의 변경사항을 반영하기 위한 목적 등으로 본 약관이나 서비스에 적용되는 추가약관을 수정할 수 있습니다. 귀하는 정기적으로 약관을 확인해야 합니다. 본 페이지의 약관이 변경되는 경우 MORY은 이에 대한 공지를 게시합니다. MORY은 추가약관의 변경 공지를 해당 서비스에 게재할 것입니다. 당해 변경은 소급되어 적용되지 않으며 게시하고 14일 이후에 발효됩니다. 단, 서비스에 대한 새로운 기능과 관련된 변경이나 법률적인 사유로 인한 변경은 즉시 발효됩니다. 서비스에 대해 변경된 약관에 동의하지 않는 경우 해당 서비스의 사용을 중지해야 합니다.

본 약관과 추가약관이 상충하는 경우, 상충하는 사항에 대하여 추가약관이 적용됩니다.

본 약관은 MORY과 귀하와의 관계를 규율하며, 어떠한 제3자의 수익권도 발생시키지 않습니다.

귀하가 본 약관을 준수하지 않은 경우, 당사가 즉시 조치를 취하지 않더라도 이는 당사가 가지고 있는 권리(향후 조치를 취하는 것 등)를 포기함을 의미하지 않습니다.

특정 조항이 집행 불가능한 것으로 판명되는 경우, 이는 다른 조항에 영향을 미치지 않습니다.

일부 국가의 법원에서는 일부 분쟁 유형에 캘리포니아 법률을 적용하지 않습니다. 캘리포니아 법률의 적용이 배제된 국가에 거주하고 있는 경우, 거주 국가의 법률이 본 약관과 관련된 분쟁에 적용될 수 있습니다. 그렇지 않은 경우, 귀하는 본 약관 또는 서비스와 관련하여 발생되는 분쟁에 대해 미국 캘리포니아주 법률이 적용되며, 캘리포니아주 국제사법의 적용은 배제된다는 것에 동의합니다. 마찬가지로, 거주 국가의 법원에서 미국 캘리포니아주 산타클라라 카운티 법원의 관할 지역이나 재판지의 적용을 동의하지 않는 경우에도 본 약관과 관련된 분쟁에 현지 관할 지역이나 재판지가 적용될 수 있습니다. 그렇지 않은 경우, 본 약관 또는 서비스와 관련하여 발생되는 모든 소송은 독점적으로 미국 캘리포니아주 산타클라라 카운티의 연방 또는 주 법원에서 다루어지며 귀하와 MORY은 이러한 법원이 인적 관할을 갖는 것에 동의합니다.

MORY에 문의하는 방법을 보려면 문의 페이지를 참조하시기 바랍니다.
</textarea>
				</div>
				<div class="col-md-2" style="margin-right: 40px;"></div>
				<div class="row col-md-6">
					<input type="checkbox"  id="chk3"><label for="chk3">위 약관을 확인 하였고 동의합니다.</label>
				</div>

			</div>
			<div class="col-xs-11 col-md-1" id="b3">
		
			</div>
		</div>
	<div class=" col-xs-6 col-md-6 text-center">
					<button type="button" class="btn btn-default" onclick="location.href='main.do'" id="preBtn">이전</button>
				</div>
				<div class=" col-xs-6 col-md-6 text-center">
					<button type="button" class="btn btn-default" id="nextBtn">다음</button>
				</div>

		<!-- 세번째 row  -->
		<c:import url="../../Footer.jsp" />

	</div>

</body>
</html>