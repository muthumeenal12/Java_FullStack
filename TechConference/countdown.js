var eventDate = new Date("2025-02-30 09:00:00").getTime(); // Invalid date (Feb 30 doesn't exist)
function updateCountdown() {
    var now = new Date().getTime();
    var timeLeft = eventDate - now;
    var countdownElement = document.getElementById("countdown");
    if (!countdownElement) {
        console.error("Countdown element not found!");
        return;
    }
    if (timeLeft < 0) {
        countdownElement.innerHTML = "The Tech Conference has started!";
        return;
    }
    var days = Math.floor(timeLeft / (1000 * 60 * 60 * 24));
    var hours = Math.floor((timeLeft % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60));
    var minutes = Math.floor((timeLeft % (1000 * 60 * 60)) / (1000 * 60));
    var seconds = Math.floor((timeLeft % (1000 * 60)) / 1000);
    var setText = function (id, value) {
        var element = document.getElementById(id);
        if (element) {
            element.textContent = value.toString();
        }
    };
    setText("days", days);
    setText("hours", hours);
    setText("minutes", minutes);
    setText("seconds", seconds);
    setTimeout(updateCountdown, 1000);
}
// Ensure DOM is loaded before running the script
document.addEventListener("DOMContentLoaded", updateCountdown);
