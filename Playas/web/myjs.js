document.addEventListener('DOMContentLoaded', () => {
    console.log('ready')
    init()
});

function init() {
    onShowReviews()
}

function onShowReviews() {
    const modalReviews = document.getElementById('modalReviews')
    if (modalReviews) {
        modalReviews.addEventListener('show.bs.modal', (event) => {
            console.log('kk')
            const button = event.relatedTarget
            const idPlaya = button.getAttribute('data-bs-idPlaya')
	    console.log(idPlaya)
            const url = "Controller?op=loadReviews&idPlaya=" + idPlaya
            const resumen = modalReviews.querySelector('.modal-body')
            resumen.innerHTML = "<p>Cargando...</p>"
            // default method get
            fetch(url)
                    .then(promise => {
                        return promise.text()
                    })
                    .then(result => {
                        resumen.innerHTML = result.trim()
                    })
        })
    }
}


