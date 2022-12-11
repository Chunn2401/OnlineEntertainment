<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- Modal -->
	<div class="modal fade" id="exampleModal" tabindex="-1"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Chia sẻ</h5>
					<button type="button" class="btn-close" data-mdb-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<div class="modal-body">
				

						<!-- Email input -->
						<div class="form-outline mb-4">
							<input id="txtEmail" type="email" class="form-control" />
							<label class="form-label" for="txtEmail">Địa chỉ email</label>
						</div>

						<!-- Message input -->
						<div class="form-outline mb-4">
							<textarea id="txtContent" class="form-control" rows="4"></textarea>
							<label class="form-label" for="txtContent">Nội dung</label>
						</div>

						<!-- Submit button -->
						<button type="button" class="btn btn-secondary" data-mdb-dismiss="modal">Đóng</button>
						<button onclick="loadShare()" class="btn btn-primary">Gửi</button>
					
				</div>
			</div>
		</div>
	</div>
	<!-- Modal -->
	
	<!-- Modal -->
	<div class="modal top fade" id="ModalEdit" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true" data-mdb-backdrop="true" data-mdb-keyboard="true">
	  <div class="modal-dialog  ">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h5 class="modal-title" id="exampleModalLabel">Cảnh báo</h5>
	        <button type="button" class="btn-close" data-mdb-dismiss="modal" aria-label="Close"></button>
	      </div>
	      <div class="modal-body">Fuck !</div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-secondary" data-mdb-dismiss="modal">
	          Close
	        </button>
	      </div>
	    </div>
	  </div>
	</div>
	<!-- Modal -->
	
	<!-- Modal -->
	<div class="modal top fade" id="ModalDone" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true" data-mdb-backdrop="true" data-mdb-keyboard="true">
	  <div class="modal-dialog  ">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h5 class="modal-title" id="exampleModalLabel">Thông báo</h5>
	        <button type="button" class="btn-close" data-mdb-dismiss="modal" aria-label="Close"></button>
	      </div>
	      <div class="modal-body">
	      <p>Thành công !</p>
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-secondary" data-mdb-dismiss="modal">
	          Close
	        </button>
	      </div>
	    </div>
	  </div>
	</div>
	<!-- Modal -->
	
	<!-- Modal -->
	<div class="modal top fade" id="ModalFail" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true" data-mdb-backdrop="true" data-mdb-keyboard="true">
	  <div class="modal-dialog  ">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h5 class="modal-title" id="exampleModalLabel">Thông báo</h5>
	        <button type="button" class="btn-close" data-mdb-dismiss="modal" aria-label="Close"></button>
	      </div>
	      <div class="modal-body">
	      <p>Thất bại !</p>
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-secondary" data-mdb-dismiss="modal">
	          Close
	        </button>
	      </div>
	    </div>
	  </div>
	</div>
	<!-- Modal -->
</body>
</html>