const formulario = document.querySelector(".formulario");
const Inome = document.querySelector(".nome");
const Itel = document.querySelector(".tel");
const Icpf = document.querySelector(".cpf");
const Iemail = document.querySelector(".email");
const Isexo = document.querySelector(".sexo");
const Icep = document.querySelector(".cep");
const Iendereco = document.querySelector(".endereco");
const Inumero = document.querySelector(".numero");

function cadastrar () {
    fetch("http://localhost:8080/cadastrar", {
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        method: "POST",
        body: JSON.stringify({
            nome: Inome.value,
            telefone: Itel.value,
            cpf: Icpf.value,
            email: Iemail.value,
            sexo: Isexo.value,
            cep: Icep.value,
            endereco: Iendereco.value,
            numero: Inumero.value
        })
    })
    .then(function (res) {console.log(res) })
    .catch(function (res) { console.log(res) })
};

function limpar () {
    Inome.value = "";
    Itel.value  = "";
    Icpf.value = "";
    Iemail.value = "";
    Isexo.value = "";
    Icep.value = "";
    Iendereco.value = "";
    Inumero.value  = "";
};

formulario.addEventListener('submit', function (event) {
    event.preventDefault();
    cadastrar();
    limpar();
});