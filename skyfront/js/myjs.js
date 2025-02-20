document.addEventListener('DOMContentLoaded', () => {
    console.log('ready')
    init()
});

function init() {
    getProvincias()
    getEstaciones()
}

function getProvincias() {
    const divprovincias = document.getElementById("provincias")
    // default method get
    let url = 'http://localhost:8080/provincias'
    fetch(url)
            .then(promise => {
                return promise.json()
            })
            .then(json => {
                console.log(json)
                let cadena = ""
                json.forEach(provincia => {
                    cadena +=  `
                            <div class="col-sm-6 col-lg-2">
                                <div class="text-center bg-info text-dark p-3">
                                    <h4>${provincia.nombre}</h4>
                                </div>
                            </div> 
                            `
                });
                divprovincias.innerHTML = cadena
            })
}

function getEstaciones() {
    const divestaciones = document.getElementById("estaciones")
    // default method get
    let url = 'http://localhost:8080/estaciones'
    fetch(url)
            .then(promise => {
                return promise.json()
            })
            .then(json => {
                console.log(json)
                let cadena = ""
                json.forEach(estacion => {
                    cadena += 
                    '<div class="col-6 col-lg-3 mb-4 d-flex">'+
                        '<div class="card text-white position-relative pb-5 flex-fill">'+
                            '<h4 class="bg-dark py-3 my-0 px-2">'+estacion.nombre+'</h4>'+
                            '<h6 class="bg-primary py-2 px-2 my-0">España: Cantábria</h6>'+
                            '<div class="card-body">'+
                                '<div class="row align-items-center">'+
                                    '<div class="col-4">'+
                                        '<img class="card-img-top" src="'+estacion.logo+'" alt="logo" />'+
                                    '</div>'+
                                    '<div class="col-8">'+
                                        '<h5 class="card-title text-dark text-center">'+estacion.km+' Kilómetros</h5>'+
                                    '</div>'+
                                '</div>'+
                                '<div>'+
                                    '<a href=""><i class="fa fa-info-circle text-dark fa-3x position-absolute bottom-0 start-0 m-3" aria-hidden="true"></i></a>'+
                                    '<a href=""><i class="fa fa-commenting text-dark fa-3x position-absolute bottom-0 end-0 m-3" aria-hidden="true"></i></a>'+
                                '</div>'+
                            '</div>'+
                        '</div>'+
                    '</div>'
                });
                divestaciones.innerHTML = cadena
            })
}

