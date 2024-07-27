<!DOCTYPE html>
<html class="dark">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link href="https://unpkg.com/tailwindcss@^2/dist/tailwind.min.css"
	rel="stylesheet" />
<title>Login Page</title>
</head>
<body class="bg-gray-900 text-gray-300">
	<div class="flex justify-center h-screen">
		<div class="hidden bg-cover lg:block lg:w-2/3"
			style="background-image: url(https://images.unsplash.com/photo-1616763355603-9755a640a287?ixlib=rb-1.2.1&amp;ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&amp;auto=format&amp;fit=crop&amp;w=1470&amp;q=80);">
			<div class="flex items-center h-full px-20 bg-gray-900 bg-opacity-40">
				<div>
					<h2 class="text-2xl font-bold text-white sm:text-3xl">Meraki
						UI</h2>
					<p class="max-w-xl mt-3 text-gray-300">Lorem ipsum dolor sit,
						amet consectetur adipisicing elit. In autem ipsa, nulla laboriosam
						dolores, repellendus perferendis libero suscipit nam temporibus
						molestiae</p>
				</div>
			</div>
		</div>

		<div class="flex items-center w-full max-w-md px-6 mx-auto lg:w-2/6">
			<div class="flex-1">
				<div class="text-center">
					<div class="flex justify-center mx-auto">
						<img class="w-auto h-7 sm:h-8"
							src="https://merakiui.com/images/logo.svg" alt="" />
					</div>
					<p class="mt-3 text-gray-500">Sign in to access your account</p>
				</div>

				<div class="mt-8">
					<form>
						<div>
							<label for="email" class="block mb-2 text-sm">Email
								Address</label> <input type="email" name="email" id="email"
								placeholder="example@example.com"
								class="block w-full px-4 py-2 mt-2 text-gray-700 placeholder-gray-400 bg-gray-800 border border-gray-700 rounded-lg focus:border-blue-400 focus:ring-blue-400 focus:outline-none focus:ring focus:ring-opacity-40" />
						</div>

						<div class="mt-6">
							<div class="flex justify-between mb-2">
								<label for="password" class="text-sm">Password</label> <a
									href="#"
									class="text-sm text-gray-400 hover:text-blue-500 hover:underline">Forgot
									password?</a>
							</div>

							<input type="password" name="password" id="password"
								placeholder="Your Password"
								class="block w-full px-4 py-2 mt-2 text-gray-700 placeholder-gray-400 bg-gray-800 border border-gray-700 rounded-lg focus:border-blue-400 focus:ring-blue-400 focus:outline-none focus:ring focus:ring-opacity-40" />
						</div>

						<div class="mt-6">
							<button
								class="w-full px-4 py-2 tracking-wide text-white transition-colors duration-300 transform bg-blue-500 rounded-lg hover:bg-blue-400 focus:outline-none focus:bg-blue-400 focus:ring focus:ring-blue-300 focus:ring-opacity-50">
								Sign in</button>
						</div>
					</form>

					<p class="mt-6 text-sm text-center text-gray-400">
						Don't have an account yet? <a href="userSignup.jsp"
							class="text-blue-500 hover:underline">Sign up</a>.
					</p>
					<p class="mt-6 text-sm text-center text-gray-400">
						Go back <a href="${pageContext.request.contextPath}"
							class="text-blue-500 hover:underline">home</a>.
					</p>

				</div>
			</div>
		</div>
	</div>
</body>
</html>
