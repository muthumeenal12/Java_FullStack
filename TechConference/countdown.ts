const eventDate: number = new Date("2025-02-30 09:00:00").getTime(); // Invalid date (Feb 30 doesn't exist)

function updateCountdown(): void {
    const now: number = new Date().getTime();
    const timeLeft: number = eventDate - now;

    const countdownElement = document.getElementById("countdown");
    if (!countdownElement) {
        console.error("Countdown element not found!");
        return;
    }

    if (timeLeft < 0) {
        countdownElement.innerHTML = "The Tech Conference has started!";
        return;
    }

    const days: number = Math.floor(timeLeft / (1000 * 60 * 60 * 24));
    const hours: number = Math.floor((timeLeft % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60));
    const minutes: number = Math.floor((timeLeft % (1000 * 60 * 60)) / (1000 * 60));
    const seconds: number = Math.floor((timeLeft % (1000 * 60)) / 1000);

    const setText = (id: string, value: number) => {
        const element = document.getElementById(id);
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
