<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>
        <c:out value="${video.title}" />
    </title>
    <!-- Font Awesome -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css" rel="stylesheet" />
    <!-- Google Fonts -->
    <link href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap" rel="stylesheet" />
    <!-- MDB -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/3.10.1/mdb.min.css" rel="stylesheet" />
    <script type="text/javascript" src="../js/style.js"></script>
    <style type="text/css">
        body {
            background-color: #343434;
        }
    </style>
</head>

<body>
    <!-- Navbar -->
    <jsp:include page="/views/user/layout/menu.jsp"></jsp:include>


    <br>
    <br>
    <br>
    <br>
    <div class="container">
        <div class="row">
            <div class="col-md-8">
                <div class="mt-3">
                    <div class="ratio ratio-16x9">
                        <iframe src="https://www.youtube.com/embed/${video.id}" title="YouTube video" allowfullscreen></iframe>
                    </div>
                    <div class="card-body">
                        <h5 class="card-title text-light">
						<c:out value="${video.title}" />
					</h5>
                        <div class="row">
                            <div class="col-md-8">
                                <p class="card-text">
                                    <c:out value="${video.views}" /> lượt xem
                                </p>
                            </div>
                            <div class="col-md-4">
                                <c:if test="${!isLike}">
                                    <button onclick="loadMore()" class="btn btn-outline-success btn-floating" id="btn-like"><i class="far fa-thumbs-up"></i>
                                    </button>
                                </c:if>

                                <c:if test="${isLike}">
                                    <button onclick="loadMore()" class="btn btn-danger btn-floating" id="btn-like"><i class="far fa-thumbs-up"></i>
                                    </button>
                                </c:if>
                                <a id="countLike">${countLike }</a>

                                <a type="button" class="btn btn-danger btn-floating mx-4" data-mdb-toggle="modal" data-mdb-target="#exampleModal">
                                    <i class="fas fa-share"></i>
                                </a>
                            </div>
                        </div>
                        <hr>
                    </div>

                    <div class="container">

                        <div class="col-12 py-2">
                            <p class="note note-primary">
                                <strong>Mô tả:</strong>
                                <c:out value="${video.description}" />
                            </p>

                        </div>

                        <c:if test="${not empty message}">
                            <div class="alert alert-success" role="alert">${message}</div>
                        </c:if>
                        <c:if test="${not empty error}">
                            <div class="alert alert-danger" role="alert">${error}</div>
                        </c:if>
                    </div>
                </div>
                <div class="fb-comments container" data-href="<c:out value="${pageContext.request.requestURL}" />" data-width="100%" data-numposts="5"></div>
                <!-- Section: Video Action -->
				<section class="">
					<div class="container text-light my-5">
						<h4 class="text-uppercase black-text mx-3"><i class="fas fa-film"></i> LỊCH SỬ</h4>
						<!-- Carousel wrapper -->
			
						<!-- Controls -->
						<div class="d-flex justify-content-center mb-4">
			
							<div class="container">
								<div class="row">
									<!--Item 1-->
									<c:forEach var="video" items="${history_video }">
										<!--Video Item-->
										<div class="col-6 col-md-3 py-3 span3 wow swing center">
											<div class="bg-image hover-overlay ripple position-relative"
												data-mdb-ripple-color="light">
												<img src="<c:url value = "/uploads/"/>${video.poster }"
													class="img-fluid" />
												<div class="mask"
													style="background-color: rgba(251, 251, 251, 0.2)">
													<a href="<c:url value = "/detail?id=${video.id }"/>"><i
														class="far fa-play-circle fa-5x position-absolute top-50 start-50 translate-middle"></i></a>
			
												</div>
											</div>
											<a href="<c:url value = "/detail?id=${video.id }"/>"><small
												class="text-truncat text-light py-1">${video.title }</small></a>
										</div>
									</c:forEach>
								</div>
							</div>
						</div>
					</div>
				</section>
				<!-- Section: Video action -->
            </div>
            <div class="col-md-4">
                <c:forEach var="video" items="${video_recomment }">
                    <div class="bg-image hover-overlay row" style="margin-bottom: 10px;">
                        <div class="col-6">
                            <img src="<c:url value = "/uploads/"/>${video.poster }" class="img-fluid w-100" />
                            <a href="<c:url value = "/detail?id="/>${video.id }">
                                <div class="mask" style="background-color: rgba(251, 251, 251, 0.2)"></div>
                            </a>
                        </div>

                        <div class="col-6">
                            <h6 class="card-text text-light text-truncate"><c:out value="${video.title }" /></h6>
                            <p class="fst-italic text-truncate">
                                <c:out value="${video.views }" /> lượt xem</p>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>

    </div>

    <jsp:include page="/views/user/layout/footer.jsp"></jsp:include>
    <jsp:include page="/views/user/layout/modalShare.jsp"></jsp:include>
    <div id="fb-root"></div>
</body>
<script async defer crossorigin="anonymous" src="https://connect.facebook.net/en_GB/sdk.js#xfbml=1&version=v13.0&appId=493217671994959&autoLogAppEvents=1" nonce="MVab7WJ7"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/3.10.1/mdb.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<script type="text/javascript">
    function loadMore() {
    	var id;
        var countLike = document.getElementById("countLike");
        id = '${video.id}';

        $.ajax({
            type: "POST",
            data: {
                id: id
            },
            url: "<c:url value = "/like "/>"
        }).then(function(data) {
            console.log("done!");
            const element = document.getElementById("btn-like");
            if (element.className.includes("success")) {
                element.className = "btn btn-danger btn-floating";
                document.getElementById("countLike").innerHTML = data;
            } else {
                element.className = "btn btn-outline-success btn-floating";
                document.getElementById("countLike").innerHTML = data;
            }
        }).fail(function(error) {
            console.log("fail!");
            const myModalEl = document.getElementById('ModalEdit');
            const modal = new mdb.Modal(myModalEl);
            modal.show();
        });
    }

    function loadShare() {
        var vId = '${video.id}';
        var email = document.getElementById("txtEmail").value;
        var content = document.getElementById("txtContent").value;
        console.log(vId);
        console.log(email);
        $.ajax({
            type: "POST",
            data: {
                vId: vId,
                email: email,
                content:content
                
            },
            url: "<c:url value = "/share "/>"
        }).then(function(data) {
            console.log("done!");
            
            const myModalEl = document.getElementById('ModalDone');
            const modal = new mdb.Modal(myModalEl);
            modal.show();
            
            const shareModalEl = document.getElementById('exampleModal');
            const shareModal = new mdb.Modal(shareModalEl);
            shareModal.hide();
            
        }).fail(function(error) {
            console.log("fail!");
            const myModalEl = document.getElementById('ModalFail');
            const modal = new mdb.Modal(myModalEl);
            modal.show();
        });
    }
</script>

</html>