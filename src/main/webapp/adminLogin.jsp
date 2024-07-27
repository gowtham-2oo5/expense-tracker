<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>EET Admin Login</title>
<script src="https://cdn.tailwindcss.com"></script>
<script>
    tailwind.config = {
        theme: {
            extend: {},
        },
        plugins: [tailwindcss.plugin.forms],
    }
</script>
</head>
<body class="bg-gray-900 flex items-center justify-center min-h-screen">
    <div class="w-full max-w-md px-6 py-8 bg-gray-800 rounded-lg shadow-lg">
        <h1 class="text-center text-3xl font-bold text-indigo-400 mb-6">Admin Login</h1>
        <p class="text-center text-gray-400 mb-8">Access the Employee Expense Tracker admin panel to manage and oversee expense reports.</p>

        <form id="adminLoginForm" class="space-y-6" action="adminLogin" method="post" onsubmit="return validateForm()">
            <p class="text-center text-xl font-medium text-white mb-6">Sign in to your admin account</p>

            <%
            if (request.getAttribute("error") != null) {
            %>
            <div id="server-error-container"
                class="bg-red-100 border border-red-400 text-red-700 px-4 py-3 rounded relative mb-4"
                role="alert">
                <span id="server-error-message" class="block sm:inline"><%=request.getAttribute("error")%></span>
            </div>
            <%
            }
            %>

            <div id="client-error-container" class="hidden bg-red-100 border border-red-400 text-red-700 px-4 py-3 rounded relative mb-4" role="alert">
                <span id="client-error-message" class="block sm:inline"></span>
            </div>

            <div>
                <label for="uname" class="sr-only">Username</label>
                <div class="relative">
                    <input type="text" id="uname" name="uname"
                        class="w-full rounded-lg border-gray-600 bg-gray-700 p-4 pr-12 text-sm text-white placeholder-gray-400 focus:border-indigo-500 focus:ring-indigo-500"
                        placeholder="Enter username" required />
                    <span class="absolute inset-y-0 right-0 flex items-center pr-4">
                        <img alt="userIcon" src="./resources/images/user.png" class="w-5 h-5" />
                    </span>
                </div>
            </div>

            <div>
                <label for="password" class="sr-only">Password</label>
                <div class="relative">
                    <input type="password" id="password" name="pass"
                        class="w-full rounded-lg border-gray-600 bg-gray-700 p-4 pr-12 text-sm text-white placeholder-gray-400 focus:border-indigo-500 focus:ring-indigo-500"
                        placeholder="Enter password" required />
                    <span class="absolute inset-y-0 right-0 flex items-center pr-4">
                        <svg xmlns="http://www.w3.org/2000/svg" class="h-5 w-5 text-gray-400" viewBox="0 0 20 20" fill="currentColor">
                            <path fill-rule="evenodd"
                                d="M5 9V7a5 5 0 0110 0v2a2 2 0 012 2v5a2 2 0 01-2 2H5a2 2 0 01-2-2v-5a2 2 0 012-2zm8-2v2H7V7a3 3 0 016 0z"
                                clip-rule="evenodd" />
                        </svg>
                    </span>
                </div>
            </div>

            <button type="submit"
                class="w-full rounded-lg bg-indigo-600 px-5 py-3 text-sm font-medium text-white transition-colors duration-300 hover:bg-indigo-700 focus:outline-none focus:ring-2 focus:ring-indigo-500 focus:ring-offset-2">
                Sign in</button>
        </form>
        <p class="mt-6 text-sm text-center text-gray-400">
            Go back <a href="${pageContext.request.contextPath}"
                class="text-indigo-500 text-xl font-semibold hover:underline">home</a>.
        </p>
    </div>

    <script>
        function validateForm() {
            const username = document.getElementById('uname').value;
            const password = document.getElementById('password').value;
            const clientErrorContainer = document.getElementById('client-error-container');
            const clientErrorMessage = document.getElementById('client-error-message');

            if (username === '' || password === '') {
                clientErrorMessage.innerText = 'Both fields are required.';
                clientErrorContainer.classList.remove('hidden');
                return false;
            }

            if (password.length < 6) {
                clientErrorMessage.innerText = 'Password must be at least 6 characters long.';
                clientErrorContainer.classList.remove('hidden');
                return false;
            }

            clientErrorContainer.classList.add('hidden');
            return true;
        }
    </script>
</body>
</html>
