document.addEventListener('DOMContentLoaded', () => {
    console.log('ready')
    init()
});

function init() {
    onshowapostar()
}

function onshowapostar() {
    const modalApuesta = document.getElementById('modalApuesta')
    if (modalApuesta) {
        modalApuesta.addEventListener('show.bs.modal', (event) => {
            const button = event.relatedTarget
            const partido = button.getAttribute('data-bs-partido')
            const local = button.getAttribute('data-bs-local')
            const visitante = button.getAttribute('data-bs-visitante')
            modalApuesta.querySelector('h5').textContent = local + ' - ' + visitante
            modalApuesta.querySelector('form').setAttribute('action', 'Controller?op=apuesta&partido=' + partido)
        })
    }
}
