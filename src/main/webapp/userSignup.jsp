<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html class="dark">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link href="https://unpkg.com/tailwindcss@^2/dist/tailwind.min.css"
	rel="stylesheet" />
<link
	href="https://cdn.jsdelivr.net/npm/flowbite@2.4.1/dist/flowbite.min.css"
	rel="stylesheet" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" />
<title>Register</title>
<style>
.error-message {
	color: #ef4444;
	font-size: 0.875rem; /* Adjust as needed */
	margin-top: 0.25rem; /* Space between input and error message */
	display: block; /* Ensures the error message is on its own line */
}

#passwordError {
	white-space: pre-line;
}

input[type="radio"]+label {
	background-color: #1f2937; /* Dark background color */
	border-color: #374151; /* Dark border color */
}

input[type="radio"]:checked+label {
	border: 2px solid #1d4ed8; /* Blue border color when checked */
	color: #ffffff; /* White text color when checked */
}

input[type="radio"]:checked+label .fa-check-circle {
	display: inline-block; /* Display check mark icon when checked */
}

input[type="radio"]+label .fa-check-circle {
	display: none; /* Hide check mark icon when not checked */
}
</style>
</head>
<body>
	<section class="bg-white dark:bg-gray-900">
		<div class="flex justify-center min-h-screen">
			<div class="hidden bg-cover lg:block lg:w-2/5"
				style="background-image: url('https://images.unsplash.com/photo-1494621930069-4fd4b2e24a11?ixlib=rb-1.2.1&amp;amp;ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&amp;amp;auto=format&amp;amp;fit=crop&amp;amp;w=715&amp;amp;q=80');"></div>
			<div
				class="flex items-center w-full max-w-3xl p-8 mx-auto lg:px-12 lg:w-3/5">
				<div class="w-full">
					<h1
						class="text-2xl font-semibold tracking-wider text-gray-800 capitalize dark:text-white">
						Get your free account now.</h1>
					<p class="mt-4 text-gray-500 dark:text-gray-400">Let's get you
						all set up so you can verify your personal account and begin
						setting up your profile.</p>
					<div class="mt-6">
						<h1 class="text-gray-500 dark:text-gray-300">Sign up as:</h1>

						<
						<div class="mt-3 md:flex md:items-center md:-mx-2 w-full">
							<div class="flex justify-center">
								<div class="space-4 flex gap-10">
									<div class="relative">
										<input type="radio" id="individual" name="plan"
											value="individual" class="peer hidden" checked /> <label
											for="individual"
											class="flex items-center justify-between w-full p-4 border border-gray-700 rounded-lg cursor-pointer transition-colors peer-checked:border-blue-400">
											<div class="flex items-center">
												<i class="fas fa-user text-xl mr-3 text-gray-500"></i>
												<h3 class="text-lg text-white font-normal">Individual</h3>
											</div>
											<div class="hidden peer-checked:block">
												<i class="fas fa-check-circle text-blue-400"></i>
											</div>
										</label>
									</div>
									<div class="relative">
										<input type="radio" id="company" name="plan" value="company"
											class="peer hidden" /> <label for="company"
											class="flex items-center justify-between w-full p-4 border border-gray-700 rounded-lg cursor-pointer transition-colors peer-checked:border-blue-400">
											<div class="flex items-center">
												<img alt="emp" src="./resources/images/emp.png"
													class="w-5 h-5">
												<h3 class="text-lg text-white font-normal">A company</h3>
											</div>
											<div class="hidden peer-checked:block">
												<i class="fas fa-check-circle text-blue-400"></i>
											</div>
										</label>
									</div>
								</div>
							</div>
						</div>

						<form id="individualForm"
							class="grid grid-cols-1 md:grid-cols-2 gap-6 mt-8">
							<div>
								<label
									class="block mb-2 text-sm text-gray-600 dark:text-gray-200">First
									Name</label> <input type="text" placeholder="John"
									class="block w-full px-5 py-3 mt-2 text-gray-700 placeholder-gray-400 bg-white border border-gray-200 rounded-lg dark:placeholder-gray-600 dark:bg-gray-900 dark:text-gray-300 dark:border-gray-700 focus:border-blue-400 dark:focus:border-blue-400 focus:ring-blue-400 focus:outline-none focus:ring focus:ring-opacity-40" />
								<span class="error-message text-red-500 text-xs mt-1"></span>
							</div>
							<div>
								<label
									class="block mb-2 text-sm text-gray-600 dark:text-gray-200">Last
									name</label> <input type="text" placeholder="Snow"
									class="block w-full px-5 py-3 mt-2 text-gray-700 placeholder-gray-400 bg-white border border-gray-200 rounded-lg dark:placeholder-gray-600 dark:bg-gray-900 dark:text-gray-300 dark:border-gray-700 focus:border-blue-400 dark:focus:border-blue-400 focus:ring-blue-400 focus:outline-none focus:ring focus:ring-opacity-40" />
								<span class="error-message text-red-500 text-xs mt-1"></span>
							</div>
							<div>
								<label
									class="block mb-2 text-sm text-gray-600 dark:text-gray-200">Phone
									number</label> <input type="text" placeholder="Enter phone number"
									class="block w-full px-5 py-3 mt-2 text-gray-700 placeholder-gray-400 bg-white border border-gray-200 rounded-lg dark:placeholder-gray-600 dark:bg-gray-900 dark:text-gray-300 dark:border-gray-700 focus:border-blue-400 dark:focus:border-blue-400 focus:ring-blue-400 focus:outline-none focus:ring focus:ring-opacity-40" />
								<span class="error-message text-red-500 text-xs mt-1"></span>
							</div>
							<div>
								<label
									class="block mb-2 text-sm text-gray-600 dark:text-gray-200">Email
									address</label> <input type="email" placeholder="johnsnow@example.com"
									class="block w-full px-5 py-3 mt-2 text-gray-700 placeholder-gray-400 bg-white border border-gray-200 rounded-lg dark:placeholder-gray-600 dark:bg-gray-900 dark:text-gray-300 dark:border-gray-700 focus:border-blue-400 dark:focus:border-blue-400 focus:ring-blue-400 focus:outline-none focus:ring focus:ring-opacity-40" />
								<span class="error-message text-red-500 text-xs mt-1"></span>
							</div>
							<div>
								<label
									class="block mb-2 text-sm text-gray-600 dark:text-gray-200">Password</label>
								<input type="password" placeholder="Enter your password"
									class="block w-full px-5 py-3 mt-2 text-gray-700 placeholder-gray-400 bg-white border border-gray-200 rounded-lg dark:placeholder-gray-600 dark:bg-gray-900 dark:text-gray-300 dark:border-gray-700 focus:border-blue-400 dark:focus:border-blue-400 focus:ring-blue-400 focus:outline-none focus:ring focus:ring-opacity-40" />
								<span class="error-message text-red-500 text-xs mt-1"></span>
							</div>
							<div>
								<label
									class="block mb-2 text-sm text-gray-600 dark:text-gray-200">Confirm
									password</label> <input type="password"
									placeholder="Confirm your password"
									class="block w-full px-5 py-3 mt-2 text-gray-700 placeholder-gray-400 bg-white border border-gray-200 rounded-lg dark:placeholder-gray-600 dark:bg-gray-900 dark:text-gray-300 dark:border-gray-700 focus:border-blue-400 dark:focus:border-blue-400 focus:ring-blue-400 focus:outline-none focus:ring focus:ring-opacity-40" />
								<span class="error-message text-red-500 text-xs mt-1"></span>
							</div>
							<button
								class="flex col-span-2 items-center justify-center w-full px-6 py-3 text-lg font-semibold tracking-wide text-white capitalize transition-colors duration-300 transform bg-blue-500 rounded-lg hover:bg-blue-400 focus:outline-none focus:ring focus:ring-blue-300 focus:ring-opacity-50">
								Sign Up
								<svg xmlns="http://www.w3.org/2000/svg"
									class="w-5 h-5 ml-2 rtl:-scale-x-100" viewBox="0 0 20 20"
									fill="currentColor">
      <path fill-rule="evenodd"
										d="M7.293 14.707a1 1 0 010-1.414L10.586 10 7.293 6.707a1 1 0 011.414-1.414l4 4a1 1 0 010 1.414l-4 4a1 1 0 01-1.414 0z"
										clip-rule="evenodd" />
    </svg>
							</button>
						</form>

						<form id="companyForm"
							class="grid grid-cols-1 md:grid-cols-2 gap-6 mt-8">
							<div>
								<label
									class="block mb-2 text-sm text-gray-600 dark:text-gray-200">Company
									Name</label> <input type="text" placeholder="Acme Corp"
									class="block w-full px-5 py-3 mt-2 text-gray-700 placeholder-gray-400 bg-white border border-gray-200 rounded-lg dark:placeholder-gray-600 dark:bg-gray-900 dark:text-gray-300 dark:border-gray-700 focus:border-blue-400 dark:focus:border-blue-400 focus:ring-blue-400 focus:outline-none focus:ring focus:ring-opacity-40" />
								<span class="error-message text-red-500 text-xs mt-1"></span>
							</div>
							<div>
								<label
									class="block mb-2 text-sm text-gray-600 dark:text-gray-200">Address</label>
								<input type="text" placeholder="123 Main St"
									class="block w-full px-5 py-3 mt-2 text-gray-700 placeholder-gray-400 bg-white border border-gray-200 rounded-lg dark:placeholder-gray-600 dark:bg-gray-900 dark:text-gray-300 dark:border-gray-700 focus:border-blue-400 dark:focus:border-blue-400 focus:ring-blue-400 focus:outline-none focus:ring focus:ring-opacity-40" />
								<span class="error-message text-red-500 text-xs mt-1"></span>
							</div>
							<div>
								<label for="company-size"
									class="block mb-2 text-sm text-gray-600 dark:text-gray-200">Company
									Size</label> <select id="company-size" name="company-size"
									class="block w-full px-5 py-3 mt-2 text-gray-700 bg-white border border-gray-200 rounded-lg dark:bg-gray-900 dark:text-gray-300 dark:border-gray-700 focus:border-blue-400 dark:focus:border-blue-400 focus:ring-blue-400 focus:outline-none focus:ring focus:ring-opacity-40">
									<option value="" disabled selected>Select company size</option>
									<option value="1-10">1-10 employees</option>
									<option value="11-50">11-50 employees</option>
									<option value="51-200">51-200 employees</option>
									<option value="201-500">201-500 employees</option>
									<option value="501-1000">501-1000 employees</option>
									<option value="1000+">1000+ employees</option>
								</select> <span class="error-message text-red-500 text-xs mt-1"></span>
							</div>
							<div>
								<label
									class="block mb-2 text-sm text-gray-600 dark:text-gray-200">Company
									mail</label> <input type="email" placeholder="contact@gmail.com"
									class="block w-full px-5 py-3 mt-2 text-gray-700 placeholder-gray-400 bg-white border border-gray-200 rounded-lg dark:placeholder-gray-600 dark:bg-gray-900 dark:text-gray-300 dark:border-gray-700 focus:border-blue-400 dark:focus:border-blue-400 focus:ring-blue-400 focus:outline-none focus:ring focus:ring-opacity-40" />
								<span class="error-message text-red-500 text-xs mt-1"></span>
							</div>
							<div class="col-span-2">
								<label
									class="block mb-2 text-sm text-gray-600 dark:text-gray-200">Personal
									mail</label> <input type="email" placeholder="contact@acme.com"
									class="block w-full px-5 py-3 mt-2 text-gray-700 placeholder-gray-400 bg-white border border-gray-200 rounded-lg dark:placeholder-gray-600 dark:bg-gray-900 dark:text-gray-300 dark:border-gray-700 focus:border-blue-400 dark:focus:border-blue-400 focus:ring-blue-400 focus:outline-none focus:ring focus:ring-opacity-40" />
								<span class="error-message text-red-500 text-xs mt-1"></span>
							</div>
							<button
								class="flex col-span-2 items-center justify-center w-full px-6 py-3 text-lg font-semibold tracking-wide text-white capitalize transition-colors duration-300 transform bg-blue-500 rounded-lg hover:bg-blue-400 focus:outline-none focus:ring focus:ring-blue-300 focus:ring-opacity-50">
								Sign Up
								<svg xmlns="http://www.w3.org/2000/svg"
									class="w-5 h-5 ml-2 rtl:-scale-x-100" viewBox="0 0 20 20"
									fill="currentColor">
      <path fill-rule="evenodd"
										d="M7.293 14.707a1 1 0 010-1.414L10.586 10 7.293 6.707a1 1 0 011.414-1.414l4 4a1 1 0 010 1.414l-4 4a1 1 0 01-1.414 0z"
										clip-rule="evenodd" />
    </svg>
							</button>
						</form>


						<p class="mt-6 text-sm text-center text-gray-400">
							Already have an account? <a href="userLogin.jsp"
								class="text-blue-500 focus:outline-none focus:underline hover:underline">Sign
								in</a>.
						</p>
					</div>
				</div>
			</div>
		</div>
	</section>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	<script type="text/javascript" src="resources/js/signup-validations.js"></script>
	<script>
		$(document).ready(function() {
			$("#companyForm").hide();
			$('input[name="plan"]').change(function() {
				if ($(this).val() === "company") {
					$("#individualForm").hide();
					$("#companyForm").show();
				} else {
					$("#companyForm").hide();
					$("#individualForm").show();
				}
			});
		});
	</script>
</body>
</html>
