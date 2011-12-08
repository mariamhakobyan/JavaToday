<%@page import="co.javatoday.data.model.Article"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!-- main central container -->
<section id="content" class="cf">
	<c:if test="${not empty loggedInUser}">
	 	<c:out value="${loggedInUser.name}"/>
	</c:if>
	<!-- ajax loader -->
	<div id="loader"></div>
	<nav>
		<ul id="tabs" class="cf">
			<li class="on"><a href="/recent-articles" title="Recent Articles">Recent Articles</a></li>
			<li>
				<a href="/top-articles" title="Top Articles">Top Articles</a>
				<select name="filter">
					<option value="all">All time</option>
					<option value="month">This month</option>
					<option value="week">This week</option>
					<option value="day">Today</option>
				</select>
			</li>
			<li><a href="/read-later-articles" title="Read Later Articles">Read Later Articles</a></li>
			<li><a href="/liked-articles" title="Liked Articles">Liked Articles</a></li>
		</ul>
	</nav>
	<section id="articles" class="cf">
		<c:forEach items = "${articles.content}" var="article">
			<article>
				<div class="left cf">
					<div class="arrow">
						<a class="up" href="/vote-up" title="Vote Up this Articles">Vote Up this Articles</a>
						<a class="down" href="/vote-down" title="Vote Down this Articles">Vote Down this Articles</a>
					</div>
					<div class="count">
						<span>21</span>
						<span>1</span>
					</div>
				</div>
				<div class="right">
					<div class="name">
						<a href=""><c:out value="${article.title}"/></a>
					</div>
					<div class="resume">
						<c:out value="${article.limitedText}" escapeXml="true"/>...
					</div>
					<div class="tags">
						<a href="">San Francisco</a> &bull; <a href="">Health Care</a>
					</div>
					<div class="actions">
						<a href="">Clean Read</a> &bull; <a href="">Read later</a>
					</div>
				</div>
			</article>
		</c:forEach>
	</section>
	
	<!-- pagination -->
	<nav>
		<ul class="pagination" data-pages="4">
			<!-- TODO disable if no prev -->
			<li class="prev"><a href="" title="Previous" data-page="1">Previous</a></li>
			<c:forEach var="page" begin="1" end="${articles.totalPages}" step="1">
				<li><a class='<c:if test="${(articles.number + 1) eq page}"><c:out value="active" /> </c:if>' href="" title="Page 2" data-page="2"><c:out value="${page}" /></a></li>
			</c:forEach>
			<!-- TODO disable if no next -->
			<li class="next"><a href="" title="Next" data-page="3">Next</a></li>
		</ul>
	</nav>
	
	<!-- submenu -->
	<nav>
		<ul id="sub-menu">
			<li><a href="" title="Terms and Conditions">Terms & Conditions</a></li>
			<li><a href="<c:url value="/contact" />" title="Contact">Contact</a></li>
		</ul>
	</nav>
</section>
<!-- end of main central container -->
