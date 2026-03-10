const slider = document.getElementById("slider");

// Duplicate slides for infinite scroll
function duplicateSlides() {
    const slides = [...slider.children];
    slides.forEach(slide => slider.appendChild(slide.cloneNode(true)));
}
duplicateSlides();

// Drag feature
let isDown = false;
let startX;
let scrollStart;

slider.addEventListener("mousedown", e => {
    isDown = true;
    startX = e.pageX;
    scrollStart = slider.scrollLeft;
});

slider.addEventListener("mouseup", () => isDown = false);
slider.addEventListener("mouseleave", () => isDown = false);

slider.addEventListener("mousemove", e => {
    if (!isDown) return;
    let walk = (e.pageX - startX) * 1.3;
    slider.scrollLeft = scrollStart - walk;
});

// Infinite Loop Logic
slider.addEventListener("scroll", () => {
    const max = slider.scrollWidth / 2;

    if (slider.scrollLeft >= max) slider.scrollLeft = 1;
    if (slider.scrollLeft <= 0) slider.scrollLeft = max - 1;
});

// Smooth Manual Animation
function smoothScroll(target) {
    let start = slider.scrollLeft;
    let distance = target - start;
    let duration = 350;
    let startTime = performance.now();

    function animate(time) {
        let timePassed = time - startTime;
        let progress = Math.min(timePassed / duration, 1);
        slider.scrollLeft = start + distance * progress;

        if (progress < 1) requestAnimationFrame(animate);
    }
    requestAnimationFrame(animate);
}

// Button click
const step = 350; // width move per click

document.getElementById("rightBtn").addEventListener("click", () => {
    smoothScroll(slider.scrollLeft + step);
});

document.getElementById("leftBtn").addEventListener("click", () => {
    smoothScroll(slider.scrollLeft - step);
});
