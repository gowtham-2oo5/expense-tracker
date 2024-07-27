const validateIndividualForm = (event) => {
  event.preventDefault();
  let isValid = true;
  document
    .querySelectorAll(".error-message")
    .forEach((span) => (span.textContent = ""));

  const individualForm = document.getElementById("individualForm");

  // First Name validation
  const firstName = individualForm.querySelector('input[placeholder="John"]');
  if (firstName.value.trim() === "") {
    displayError(firstName, "First name is required.");
    isValid = false;
  }

  // Last Name validation
  const lastName = individualForm.querySelector('input[placeholder="Snow"]');
  if (lastName.value.trim() === "") {
    displayError(lastName, "Last name is required.");
    isValid = false;
  }

  // Phone Number validation
  const phoneNumber = individualForm.querySelector(
    'input[placeholder="Enter phone number"]'
  );
  const phonePattern = /^\d{10}$/;
  if (!phonePattern.test(phoneNumber.value.replace(/\D/g, ""))) {
    displayError(phoneNumber, "Please enter a valid 10-digit phone number.");
    isValid = false;
  }

  // Email validation
  const email = individualForm.querySelector(
    'input[placeholder="johnsnow@example.com"]'
  );
  const emailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
  if (!emailPattern.test(email.value.trim())) {
    displayError(email, "Please enter a valid email address.");
    isValid = false;
  }

  // Password validation
  const password = individualForm.querySelector(
    'input[placeholder="Enter your password"]'
  );
  const confirmPassword = individualForm.querySelector(
    'input[placeholder="Confirm your password"]'
  );

  let passwordErrors = [];

  if (password.value.length < 8) {
    passwordErrors.push("Password must be at least 8 characters long.");
  }
  if (!/[A-Z]/.test(password.value)) {
    passwordErrors.push("Password must contain at least one uppercase letter.");
  }
  if (!/[a-z]/.test(password.value)) {
    passwordErrors.push("Password must contain at least one lowercase letter.");
  }
  if (!/\d/.test(password.value)) {
    passwordErrors.push("Password must contain at least one number.");
  }
  if (!/[!@#$%^&*]/.test(password.value)) {
    passwordErrors.push(
      "Password must contain at least one special character (!@#$%^&*)."
    );
  }

  if (passwordErrors.length > 0) {
    displayError(password, passwordErrors.join("\n"));
    isValid = false;
  }

  if (password.value !== confirmPassword.value) {
    displayError(confirmPassword, "Passwords do not match.");
    isValid = false;
  }

  if (isValid) {
    console.log("Form is valid. Submitting...");
    // Add your form submission logic here
  }
};

const displayError = (element, message) => {
  const errorSpan = element.nextElementSibling;
  if (errorSpan && errorSpan.classList.contains("error-message")) {
    errorSpan.innerHTML = message.replace(/\n/g, "<br>");
    errorSpan.style.whiteSpace = "pre-line";
  }
};

const validateCompanyForm = (event) => {
  event.preventDefault();
  let isValid = true;
  document.querySelectorAll(".error-message").forEach((span) => span.textContent = "");

  const companyForm = document.getElementById("companyForm");

  // Company Name validation
  const companyName = companyForm.querySelector('input[placeholder="Acme Corp"]');
  if (companyName.value.trim() === "") {
    displayError(companyName, "Company name is required.");
    isValid = false;
  }

  // Address validation
  const address = companyForm.querySelector('input[placeholder="123 Main St"]');
  if (address.value.trim() === "") {
    displayError(address, "Address is required.");
    isValid = false;
  }

  // Company Size validation
  const companySize = companyForm.querySelector('#company-size');
  if (companySize.value === "") {
    displayError(companySize, "Please select a company size.");
    isValid = false;
  }

  // Company Email validation
  const companyEmail = companyForm.querySelector('input[placeholder="contact@gmail.com"]');
  const emailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
  if (!emailPattern.test(companyEmail.value.trim())) {
    displayError(companyEmail, "Please enter a valid company email address.");
    isValid = false;
  }

  // Personal Email validation
  const personalEmail = companyForm.querySelector('input[placeholder="contact@acme.com"]');
  if (!emailPattern.test(personalEmail.value.trim())) {
    displayError(personalEmail, "Please enter a valid personal email address.");
    isValid = false;
  }

  if (isValid) {
    console.log("Company form is valid. Submitting...");
    // Add your form submission logic here
  }
};

document.getElementById("companyForm").addEventListener("submit", validateCompanyForm);

document
  .getElementById("individualForm")
  .addEventListener("submit", validateIndividualForm);
