<div class="col-md-3 left_col">
				<div class="left_col scroll-view">
					<div class="navbar nav_title" style="border: 0;">
						<a href="#" class="site_title bg-primary"><img src="/resources/dashboard/bcs2.png" style="width: 43px; height: 43px; margin-right: 5px;"><span></span></a>
					</div>

					<div class="clearfix"></div>

					<!-- menu profile quick info -->
					<div class="profile clearfix">
						<div class="profile_pic">
							<img src="/resources/dashboard/images/img.jpg" alt="..." class="img-circle profile_img">
						</div>
						<div class="profile_info">
							<span>Welcome,</span>
							<h2><c:out value="${baseCommandForm.pacsPortalUser.fullName}"/></h2>
						</div>
					</div>
					<!-- /menu profile quick info -->

					<br>

					<div id="sidebar-menu" class="main_menu_side hidden-print main_menu">
						<div class="menu_section active">
							<ul class="nav side-menu">
								<li><a href="#"> <i class="fa fa-money"></i> Membership
								</a></li>

								<li class="vplist-menu"><a><i class="fa fa-group"></i> Deposit <span class="fa fa-chevron-down"></span></a>
									<ul class="nav child_menu">
										<li><a href="deposit">Account opening</a></li>
									</ul></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
			
			<!-- top navigation -->
			<div class="top_nav bg-primary">
				<span style="font-size: 20px; cursor: pointer"><span class="glyphicon glyphicon-ruble" aria-hidden="true"></span>rimary Agriculture Credit Society</span>
				<div class="nav_menu">
					<nav>
						<div class="nav toggle">
							<a id="menu_toggle" class="btn btn-primary toggle-btn"><i class="fa fa-backward"></i></a>
						</div>

						<ul class="nav navbar-nav navbar-right">
							<li class=""><a href="javascript:;" class="user-profile dropdown-toggle" data-toggle="dropdown" aria-expanded="false"> <img src="/resources/dashboard/images/img.jpg" alt=""><c:out value="${baseCommandForm.pacsPortalUser.fullName}"/> <span class=" fa fa-angle-down"></span>
							</a>
								<ul class="dropdown-menu dropdown-usermenu pull-right">
									<li><a href="#">Help</a></li>
									<li><a href="#"><i class="fa fa-sign-out pull-right"></i> Log Out</a></li>
								</ul></li>

						</ul>
					</nav>
				</div>
			</div>
			<!-- /top navigation -->