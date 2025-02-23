// registration form popup
document.addEventListener("DOMContentLoaded", function () {
    var buyTicketBtn = document.getElementById("buyTicketNav"); 
    var registerBtn = document.querySelector("button"); // Register Now button
    var popup = document.getElementById("ticketPopup");
    var closeBtn = document.querySelector(".popup-close");

    function showPopup(event) {
        event.preventDefault();
        popup.style.display = "flex";
    }

    if (buyTicketBtn) {
        buyTicketBtn.addEventListener("click", showPopup);
    }

    if (registerBtn) {
        registerBtn.addEventListener("click", showPopup);
    }

    if (closeBtn) {
        closeBtn.addEventListener("click", function () {
            popup.style.display = "none";
        });
    }

    window.addEventListener("click", function (event) {
        if (event.target === popup) {
            popup.style.display = "none";
        }
    });

    document.getElementById("ticketForm").addEventListener("submit", function (event) {
        event.preventDefault();
        alert("🎉 Ticket Booked Successfully!");
        popup.style.display = "none"; // Close popup after submission
    });
});


//navbar for mobile screen
document.addEventListener("DOMContentLoaded", function () {
    const menuIcon = document.querySelector(".menu-icon");
    const navbar = document.querySelector(".navbar");

    if (menuIcon && navbar) {
        menuIcon.addEventListener("click", function () {
            navbar.classList.toggle("active");
        });
    }
});

