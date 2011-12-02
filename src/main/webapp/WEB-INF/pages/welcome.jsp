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
					<a href="">Cake Health Track and Optimize Your Healthcare</a>
				</div>
				<div class="resume">
					Track and Optimize Your Healthcare Track and Optimize Your Healthcare and Optimize Your Healthcare Track and Optimize Your Healthcare
				</div>
				<div class="tags">
					<a href="">San Francisco</a> &bull; <a href="">Health Care</a>
				</div>
				<div class="actions">
					<a href="">Clean Read</a> &bull; <a href="">Read later</a>
				</div>
			</div>
		</article>
		<article>
			<div class="left cf">
				<div class="arrow">
					<a class="up" href="/vote-up" title="Vote Up this Articles">Vote Up this Articles</a>
					<a class="down" href="/vote-down" title="Vote Down this Articles">Vote Down this Articles</a>
				</div>
				<div class="count">
					<span>0</span>
					<span>16</span>
				</div>
			</div>
			<div class="right">
				<div class="name">
					<a href="">Cake Health</a>
				</div>
				<div class="resume">
					Track and Optimize Your Healthcare
				</div>
				<div class="tags">
					<a href="">San Francisco</a> &bull; <a href="">Health Care</a>
				</div>
			</div>
		</article>
		<article>
			<div class="left cf">
				<div class="arrow">
					<a class="up" href="/vote-up" title="Vote Up this Articles">Vote Up this Articles</a>
					<a class="down" href="/vote-down" title="Vote Down this Articles">Vote Down this Articles</a>
				</div>
				<div class="count">
					<span>9999</span>
					<span>2</span>
				</div>
			</div>
			<div class="right">
				<div class="name">
					<a href="">Cake Health</a>
				</div>
				<div class="resume">
					Track and Optimize Your Healthcare Track and Optimize Your Healthcare
				</div>
				<div class="tags">
					<a href="">San Francisco</a> &bull; <a href="">Health Care</a>
				</div>
			</div>
		</article>
		<article>
			<div class="left cf">
				<div class="arrow">
					<a class="up" href="/vote-up" title="Vote Up this Articles">Vote Up this Articles</a>
					<a class="down" href="/vote-down" title="Vote Down this Articles">Vote Down this Articles</a>
				</div>
				<div class="count">
					<span>994</span>
					<span>15</span>
				</div>
			</div>
			<div class="right">
				<div class="name">
					<a href="">Cake Health</a>
				</div>
				<div class="resume">
					Track and Optimize Your Healthcare
				</div>
				<div class="tags">
					<a href="">San Francisco</a> &bull; <a href="">Health Care</a>
				</div>
			</div>
		</article>
	</section>
	
	<!-- pagination -->
	<nav>
		<ul class="pagination" data-pages="4">
			<li class="prev"><a href="" title="Previous" data-page="1">Previous</a></li>
			<li><a href="" title="Page 1" data-page="1">1</a></li>
			<li><a class="active" href="" title="Page 2" data-page="2">2</a></li>
			<li><a href="" title="Page 3" data-page="3">3</a></li>
			<li><a href="" title="Page 4" data-page="4">4</a></li>
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
