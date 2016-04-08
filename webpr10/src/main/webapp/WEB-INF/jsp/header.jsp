<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<div class="headerBar reset-padding">
	<div id="sdHeader" class="comp comp-header reset-padding">
		<div class="topBar headWrapper ">
			<div class="logoWidth col-xs-6 reset-padding">
				<div class="menuBar " id="leftNavMenuBar">
					<a href="javascript:void(0);"> <i></i><i></i><i></i> <span>Shop</span>
					</a>
				</div>
				<i class="sdLogo mainLogo" title="Snapdeal.com"> <img
					src="<c:url value="/resources/images/logo.png"></c:url>" alt="logo" />
				</i>
			</div>	
				<!--======================Search=====================================  -->
				<div class="col-xs-10 search-box-wrapper">
					<input autocomplete="off" name="keyword" type="text"
						class="col-xs-20 searchformInput keyword"
						onkeypress="clickGo(event, this)" placeholder="Find your deal!"
						value="" />
					<button class="searchformButton col-xs-4 rippleGrey"
						onclick="submitSearchForm('go_header');">
						<!-- <span class="loading hidden"><img
						lazySrc="http://i2.sdlcdn.com/img/metroUI/loader.svg"
						type="image/svg+xml" height="20" width="20"> 
						</span>  -->
						<i class="sd-icon sd-icon-search"></i>
					</button>
				</div>
				<!--====================Panel=======================================  -->
				<div class="rfloat col-xs-7 reset-padding">
					<ul class="rhslink reset-padding">
						<li class="openCartModal" id="cartHeader">
							<div class="menuLinks">
								<i class="sd-icon sd-icon-shopping-cart"></i><small
									class="circleCountCart">0</small>
							</div>
						</li>
						<li class=" moreOptionsHeader">
							<div class="menuLinks">
								<i class="sd-icon sd-icon-9dot"></i><span class="moreText">more</span>
							</div>
						</li>
						<li class=" accountHeaderClass" id="accountHeader">
							<div class="menuLinks hoverLink">
								<i class="sd-icon sd-icon-user"></i><i
									class="sd-icon sd-icon-expand-arrow"></i><span>account</span>
							</div>
							<!-- <div class="dropdownWrapper hard-hidden">
								<div class="dropdownAccount hidden">
									<div class="accountInfoLoggedIn">
										<div class="nonLoginUser hidden">
											<i class="sd-icon sd-icon-user"></i>
										</div>
										<img alt="user Image" class="imgUser" />
										<p class="userLoginName"></p>
										<p class="userLoginEmail"></p>
										<span class="accountBtn rippleWhite"><a
											href="http://www.snapdeal.com/myorders">View My Account</a></span>
									</div>
									<div class="accountList">
										<ul>
											<li><a href="http://www.snapdeal.com/myorders">Orders</a></li>
											<li><a href="http://www.snapdeal.com/mywishlist">Shortlist</a></li>
											<li><a href="http://www.snapdeal.com/mysdcash">SD
													Cash
													<div class="sd-balance rfloat"></div>
											</a></li>
											<li><a href="http://www.snapdeal.com/myEGiftVoucher">E-Gift
													Voucher</a></li>
											<li><a href="http://www.snapdeal.com/logout"
												class="sign logout-account">Logout</a></li>
										</ul>
									</div>
								</div>
								<div class="dropdownAccountNonLoggedIn hidden">
									<div class="accountInfoNonLoggedIn">
										<div class="nonLoginUser">
											<i class="sd-icon sd-icon-user"></i>
										</div>
										<span class="accountBtn rippleWhite"><a
											href="http://www.snapdeal.com/login">login</a></span>
										<p class="newUser">
											<span>New User?</span><span class="newUserRegister">Register</span>
										</p>
									</div>
									<div class="accountList">
										<ul>
											<li><a href="http://www.snapdeal.com/myorders">Orders</a></li>
											<li><a href="http://www.snapdeal.com/mywishlist">Shortlist</a></li>
											<li><a href="http://www.snapdeal.com/mysdcash">SD
													Cash</a></li>
											<li><a href="http://www.snapdeal.com/myEGiftVoucher">E-Gift
													Voucher</a></li>
										</ul>
									</div>
								</div>
							</div> -->
						</li>
						<li class="headerShortlist"><a class="menuLinks"><i
								class="sd-icon sd-icon-marker"></i><span>Track Order</span></a></li>
						<li class="faqHelpHeader"><a class="menuLinks"><i
								class="sd-icon sd-icon-nhelpfilled"></i><span class="helptext">Help</span></a>
						</li>
					</ul>
				</div>
			</div>
		</div>
	</div>