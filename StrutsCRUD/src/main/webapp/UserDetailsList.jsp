<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<!-- Popper JS -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<!DOCTYPE html ">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>User Details</title>
        <link rel="stylesheet" href="css/bootstrap.min.css" >
        <script src="js/jquery.min.js" ></script>
        <script src="js/bootstrap.min.js"></script>
    </head>
    
    <body background="java9r.png">
        
        <div class="container">
        <div align="center"><h3>User Details</h3><hr></div>

        <table class="table" >
        <tr>
        <th><a href="userslist">@</a></th>
        <th>User Id</th>
        <th>First Name</th>
        <th>Last Name </th>
        <th>Mobile No</th>
        <th>Email Id</th>

        <th><button type="button" class="btn btn-info btn-sm" data-toggle="modal" data-target="#NewUser">+</button></th>
        </tr>

        <c:forEach var="userlists" items="${userlists}" >

        <tr>
            <td>
                <form action="deleteuser" method="post">
                    <input type="hidden" name="urb.userid" value="${userlists.userid }"  >
                    <input type="submit" class="btn btn-info btn-sm" value="-" alt="Delete">
                </form>
            </td>

            <td>${userlists.userid }</td>
            <td>${userlists.fname }</td>
            <td>${userlists.lname }</td>
            <td>${userlists.mobile }</td>
            <td>${userlists.email }</td>

            <td>
                <button type="button" class="btn btn-info btn-sm" data-toggle="modal" data-target="#Edit${userlists.userid }">Edit</button>
            </td>
        </tr>

        <!-- Modal -->
          <div class="modal fade" id="Edit${userlists.userid }" role="dialog">
            <div class="modal-dialog">
            <form action="updateuser" method="post">
              <!-- Modal content-->
              <div class="modal-content">
                <div class="modal-header">
                  <button type="button" class="close" data-dismiss="modal">&times;</button>
                  <h4 class="modal-title">Update User  Details </h4>
                </div>
                <div class="modal-body">
                 <div class="form-group">
          <label for="usr">First Name:</label>
            <input type="hidden" name="urb.userid"  value="${userlists.userid }" id="usr">

          <input type="text" name="urb.fname" class="form-control" value="${userlists.fname }" id="usr">
        </div>
            <div class="form-group">
            <label for="usr">Last Name:</label>
            <input type="text" name="urb.lname" class="form-control" value="${userlists.lname }" id="usr">
        </div>

        <div class="form-group">
            <label for="usr">Mobile No:</label>
            <input type="text" name="urb.mobile" class="form-control" value="${userlists.mobile }" id="usr">
        </div>

        <div class="form-group">
          <label for="usr">Email Id:</label>
          <input type="text" name="urb.email" class="form-control" value="${userlists.email }" id="usr">
        </div>

                </div>
                <div class="modal-footer">

                <input type="submit"  class="btn btn-default" value="Update">
                  <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                </div>
              </div>
              </form>
            </div>
          </div>
          <!-- Modal end -->




        </c:forEach>


        <!-- Modal Add New User -->
          <div class="modal fade" id="NewUser" role="dialog">
            <div class="modal-dialog">
            <form action="adduser" method="post">
              <!-- Modal content-->
              <div class="modal-content">
                <div class="modal-header">
                  <button type="button" class="close" data-dismiss="modal">&times;</button>
                  <h4 class="modal-title">Add New User  Details </h4>
                </div>
                <div class="modal-body">
                 <div class="form-group">
          <label for="usr">First Name:</label>


          <input type="text" name="urb.fname" class="form-control" id="usr">
        </div>
              <div class="form-group">
          <label for="usr">Last Name:</label>
          <input type="text" name="urb.lname" class="form-control"  id="usr">
        </div>

          <div class="form-group">
          <label for="usr">Mobile No:</label>
          <input type="text" name="urb.mobile" class="form-control"  id="usr">
        </div>

         <div class="form-group">
          <label for="usr">Email Id:</label>
          <input type="text" name="urb.email" class="form-control"  id="usr">
        </div>

        </div>
            <div class="modal-footer">

                <input type="submit"  class="btn btn-default" value="Save">
                  <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
            </div>
              </div>
              </form>
            </div>
        </div>
        <!-- Modal end -->
        </table>
    </div>
</body>
</html>