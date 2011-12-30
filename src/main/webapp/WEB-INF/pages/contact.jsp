<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!-- main central container -->
<section id="content" class="cf">
	<!-- ajax loader -->
	<div id="loader"></div>
	<h2 class="head">Contact</h2>
	<section id="contact" class="cf">
		<form action="/contact" method="post">
			<div class="form-row cf">
				<label for="data-name"><sup>*</sup>Name</label>
				<input type="text" name="name" value="" id="data-name" />
			</div>
			<div class="form-row cf">
				<label for="data-email"><sup>*</sup>E-mail</label>
				<input type="text" name="email" value="" id="data-email" />
			</div>
			<div class="form-row cf">
				<label for="data-subject"><sup>*</sup>Subject</label>
				<input type="text" name="subject" value="" id="data-subject" />
			</div>
			<div class="form-row cf">
				<label for="data-message"><sup>*</sup>Message</label>
				<textarea name="message" id="data-message" cols="40" rows="6"></textarea>
			</div>
			<div class="form-row cf">
				<input type="submit" name="submit" value="Submit" id="data-submit" />
			</div>
		</form>
		<aside>
			<div id="map"></div>
		</aside>
	</section>
</section>
<!-- end of main central container -->
