function confirmarCadastro() {
    return confirm('Tem certeza que deseja cadastrar este filme?');
}

document.addEventListener('DOMContentLoaded', function() {
    const form = document.querySelector('form');
    if (form) {
        form.onsubmit = confirmarCadastro;
    }
});