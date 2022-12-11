<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>SignUp Online Entertainment</title>
    <!-- Font Awesome -->
   <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css" rel="stylesheet" />
   <!-- Google Fonts -->
   <link href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap" rel="stylesheet" />
   <!-- MDB -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/3.10.1/mdb.min.css" rel="stylesheet" />
</head>

<body>
    <section class="vh-100" style="background-color: #eee;">
       <div class="container py-3 h-100">
           <div class="row d-flex justify-content-center align-items-center h-100">
               <div class="col-lg-12 col-xl-11">
                   <div class="card text-black" style="border-radius: 25px;">
                       <div class="card-body p-md-5">
                           <div class="row justify-content-center">
                               <div class="col-md-10 col-lg-6 col-xl-5 order-2 order-lg-1">
                                   <p class="text-center h1 fw-bold mb-5 mx-1 mx-md-4 mt-4">Registration</p>
                                   <form class="mx-1 mx-md-4" action="/OnlineEntertaiment/account/sign-up" method="post">
                                       <div class="d-flex flex-row align-items-center mb-4">
                                           <i class="fas fa-user fa-lg me-3 fa-fw"></i>
                                           <div class="form-outline flex-fill mb-0">
                                               <input type="text" name="id" id="id" class="form-control" />
                                               <label class="form-label" for="id">Username</label>
                                           </div>
                                       </div>
                                       <div class="d-flex flex-row align-items-center mb-4">
                                           <i class="fas fa-user fa-lg me-3 fa-fw"></i>
                                           <div class="form-outline flex-fill mb-0">
                                               <input type="text" name="fullname" id="fullname" class="form-control" />
                                               <label class="form-label" for="fullname">Fullname</label>
                                           </div>
                                       </div>

                                       <div class="d-flex flex-row align-items-center mb-4">
                                           <i class="fas fa-envelope fa-lg me-3 fa-fw"></i>
                                           <div class="form-outline flex-fill mb-0">
                                               <input type="email" name="email" id="email" class="form-control" />
                                               <label class="form-label" for="email">Email</label>
                                           </div>
                                       </div>

                                       <div class="d-flex flex-row align-items-center mb-4">
                                           <i class="fas fa-lock fa-lg me-3 fa-fw"></i>
                                           <div class="form-outline flex-fill mb-0">
                                               <input type="password" name="password" id="password" class="form-control" />
                                               <label class="form-label" for="password">Password</label>
                                           </div>
                                       </div>

                                       <div class="d-flex flex-row align-items-center mb-4">
                                           <i class="fas fa-key fa-lg me-3 fa-fw"></i>
                                           <div class="form-outline flex-fill mb-0">
                                               <input type="password" id="re-password" class="form-control" />
                                               <label class="form-label" for="re-password">Re-enter password</label>
                                           </div>
                                       </div>

                                       <div class="d-flex flex-row align-items-center mb-4">
                                           <i class="fas fa-user-shield  fa-lg me-3 fa-1x"></i>

                                           <!-- Radio input -->
                                            <div class="m-2">
                                                <div class="form-check form-check-inline">
                                                    <input class="form-check-input" type="radio" name="admin" id="admin" value="true" />
                                                    <label class="form-check-label" for="inlineRadio1">Admin</label>
                                                </div>

                                                <div class="form-check form-check-inline">
                                                    <input class="form-check-input" type="radio" name="admin" id="user" value="false" checked />
                                                    <label class="form-check-label" for="inlineRadio2">User</label>
                                                </div>
                                            </div>
                                        </div>

                                        <div class="form-check d-flex justify-content-center mb-5">
                                            <input class="form-check-input me-2" type="checkbox" value="" id="form2Example3c" />
                                            <label class="form-check-label" for="form2Example3"> I agree to the <a href="#!">Terms of Service</a> and <a href="#!">Privacy Policy</a>
                                            </label>
                                        </div>

                                        <div class="d-flex justify-content-center mx-4 mb-3 mb-lg-4">
                                            <button type="submit" class="btn btn-primary btn-lg">Register Now</button>
                                        </div>

                                    </form>

                                </div>
                                <div class="col-md-10 col-lg-6 col-xl-7 d-flex align-items-center order-1 order-lg-2">

                                    <img src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-registration/draw1.webp" class="img-fluid" alt="Sample image">

                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
</body>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/3.10.1/mdb.min.js"></script>

</html>