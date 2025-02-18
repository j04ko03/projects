
const adoptadosSection = document.getElementById('adoptados');
const adopcionesSection = document.getElementById('adopciones');
const showAdoptadosBtn = document.getElementById('show-adoptados');
const showAdopcionesBtn = document.getElementById('show-adopciones');

showAdoptadosBtn.addEventListener('click', () => {
    adoptadosSection.classList.remove('hidden');
    adopcionesSection.classList.add('hidden');
});

showAdopcionesBtn.addEventListener('click', () => {
    adoptadosSection.classList.add('hidden');
    adopcionesSection.classList.remove('hidden');
});
