<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <!DOCTYPE html>
        <html lang="en">

        <head>
            <meta charset="UTF-8_">
            <title>Home</title>

        </head>

        <body>
            <!-- Responsive navbar-->
            <!-- Page header with logo and tagline-->
            <header class="py-5 bg-light border-bottom mb-4">
                <div class="container">
                    <div class="text-center my-5">
                        <h1 class="fw-bolder">VietNew360</h1>
                        <p class="lead mb-0">Trang thông tin điện tử</p>
                    </div>
                </div>
            </header>
            <!-- Page content-->
            <div class="container">
                <div class="row">
                    <!-- Blog entries-->
                    <div class="col-lg-8">
                        <!-- Featured blog post-->
                        <div class="card mb-4">
                            <a href="#!"><img class="card-img-top"
                                    src="https://dummyimage.com/850x350/dee2e6/6c757d.jpg" alt="..." /></a>
                            <div class="card-body">
                                <div class="small text-muted">January 1, 2023</div>
                                <h2 class="card-title">Featured Post Title</h2>
                                <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipisicing elit.
                                    Reiciendis
                                    aliquid atque, nulla? Quos cum ex quis soluta, a laboriosam. Dicta expedita corporis
                                    animi
                                    vero voluptate voluptatibus possimus, veniam magni quis!</p>
                                <a class="btn btn-primary" href="./post.html">Read more →</a>
                            </div>
                        </div>
                        <!-- Nested row for non-featured blog posts-->
                        <div class="row">
                           <c:forEach var="item" items="${model.listResult}">
                            <div class="col-lg-6 ">
                                <!-- Blog post-->
                               
                                    <div class="card mb-4">
                                        <a href="#!"><img class="card-img-top"
                                                src="https://dummyimage.com/700x350/dee2e6/6c757d.jpg" alt="..." /></a>
                                        <div class="card-body">
                                            <div class="small text-muted">${item.createdDate}</div>
                                            <h2 class="card-title h4">${item.title}</h2>
                                            <p class="card-text">${item.shortDescription}</p>
                                            <a class="btn btn-primary" href="./post.html">Read more →</a>
                                        </div>
                                    </div>
                               

                            </div>
                             </c:forEach>


                        </div>

                        <!-- Pagination-->
                        <nav aria-label="Pagination">
                             <hr class="my-0" />
                    <ul class="pagination justify-content-center my-4">
                    <!-- <form action="<c:url value='/trang-chu'/>" >
                        <ul class="pagination" id="pagination"></ul>
                        <input type="hidden" value="1" id="page" name="page"/>
					    <input type="hidden" value="5" id="limit" name="limit"/>		
 
                    </form>  -->
                    <c:if test="${totalPages > 1}">
            <ul class="pagination">
                <li class="page-item ${currentPage == 1 ? 'disabled' : ''}">
                    <a class="page-link" href="/trang-chu?page=${currentPage - 1}">Previous</a>
                </li>
                <c:forEach begin="1" end="${totalPages}" var="pageNumber">
                    <li class="page-item ${currentPage == pageNumber ? 'active' : ''}">
                        <a class="page-link" href="/trang-chu?page=${pageNumber}">${pageNumber}</a>
                    </li>
                </c:forEach>
                <li class="page-item ${currentPage == totalPages ? 'disabled' : ''}">
                    <a class="page-link" href="/trang-chu?page=${currentPage + 1}">Next</a>
                </li>
            </ul>
        </c:if>
                   
                    </ul>
                        </nav>
                    </div>
                    <!-- Side widgets-->
                    <div class="col-lg-4">
                        <!-- Categories widget-->

                        <div class="card mb-4">
                            <div class="card-header">Danh mục</div>
                            <div class="card-body">
                                <form action="/trang-chu/tim-kiem" id="formSubmit">
                                    <div class="card-body">
                                        <label for="">Chọn : </label>
                                        <select name="cars" id="cars">
                                            <option value="">--Danh mục--</option>
                                            <c:forEach items="${categories}" var="entry">
                                                <option value="${entry.key}">${entry.value}</option>
                                            </c:forEach>

                                        </select>
                                    </div>


                            </div>
                            <!-- Search widget-->
                            <div class="card mb-4">
                                <div class="card-header">Tìm kiếm</div>
                                <div class="card-body">
                                    <form action="/trang-chu/tim-kiem">
                                        <div class="input-group">

                                            <input class="form-control" type="text"
                                                placeholder="Nhập cụm từ tìm kiếm..." aria-label="Enter search term..."
                                                aria-describedby="button-search" name="search" />
                                            <button class="btn btn-primary" id="button-search" type="submit">Tìm
                                                kiếm</button>


                                        </div>
                                    </form>
                                </div>
                            </div>

                            <!-- Side widget-->
                            <div class="card mb-4">
                                <div class="card-header">Side Widget</div>
                                <div class="card-body">You can put anything you want inside of these side widgets. They
                                    are
                                    easy
                                    to use, and feature the Bootstrap 5 card component!</div>
                                <div class="card mb-4">
                                    <a href="#!"><img class="card-img-top"
                                            src="https://dummyimage.com/700x350/dee2e6/6c757d.jpg" alt="..." /></a>
                                    <div class="card-body">
                                        <div class="small text-muted">January 1, 2023</div>
                                        <h2 class="card-title h4">Post Title</h2>
                                        <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipisicing elit.
                                            Reiciendis aliquid atque, nulla? Quos cum ex quis soluta, a laboriosam.</p>
                                        <a class="btn btn-primary" href="#!">Read more →</a>
                                    </div>
                                </div>
                            </div>
                            </form>
                        </div>

                    </div>
                    <script>
                    var totalPages =  ${model.totalPage};;
        			var currentPage = ${model.page};
                        $(function () {
                            window.pagObj = $('#pagination').twbsPagination({
                                totalPages: 10,
                                visiblePages: 10,
                                startPage: 1,
                                onPageClick: function (event, page) {                       
                                    if (currentPage != page) {
            		            		$('#limit').val(5);
            							$('#page').val(page);
            							$('#formSubmit').submit();
            						}

                                }
                            })
                        });
                    </script>

                    <!-- Bootstrap core JS-->
                    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
                    <!-- Core theme JS-->
                    <script src="js/scripts.js"></script>
        </body>

        </html>