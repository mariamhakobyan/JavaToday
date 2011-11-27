<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!-- main central container -->
<section id="content" class="cf">
	<!-- ajax loader -->
	<div id="loader"></div>
	<h2 class="head">Articles</h2>
	<c:if test="${not empty loggedInUser}">
	 	<c:out value="${loggedInUser.name}"/>
	</c:if>
	<section id="articles" class="cf">
		<article>
			<figure>
				<a href="">
					<img alt="Cake Health" data-id="21312" data-type="Startup" src="" />
				</a>
			</figure>
			<div class="right">
				<div class="name">
					<a href="">Cake Health Track and Optimize Your Healthcare</a>
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
			<figure>
				<a href="">
					<img alt="Cake Health" data-id="21312" data-type="Startup" src="" />
				</a>
			</figure>
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
		<article class="cf"></article>
		<article>
			<figure>
				<a href="">
					<img alt="Cake Health" data-id="21312" data-type="Startup" src="" />
				</a>
			</figure>
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
			<figure>
				<a href="">
					<img alt="Cake Health" data-id="21312" data-type="Startup" src="" />
				</a>
			</figure>
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
</section>
<!-- end of main central container -->
