document.addEventListener('DOMContentLoaded', () => {
  // Select all "More Info" buttons
  const infoButtons = document.querySelectorAll('.info-btn');

  // Add event listeners to each button
  infoButtons.forEach(button => {
    button.addEventListener('click', () => {
      // Get the corresponding course info section
      const courseId = button
