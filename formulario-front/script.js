const formulario = document.querySelector(".formulario");
const Inome = document.querySelector(".nome");
const Itel = document.querySelector(".tel");
const Icpf = document.querySelector(".cpf");
const Iemail = document.querySelector(".email");
const Isexo = document.querySelector(".sexo");
const Icep = document.querySelector(".cep");
const Iendereco = document.querySelector(".endereco");
const Inumero = document.querySelector(".numero");

function exibirErro(mensagem) {
    alert(mensagem)
}

function validarCampos() {
    if (!Inome.value.trim()) {
        exibirErro("O campo 'nome' é obrigatório");
        return false;
    }

    if(!Itel.value.trim()) {
        exibirErro("O campo 'telefone' é obrigatório");
        return false;
    }

    if(!Icpf.value.trim()) {
        exibirErro("O campo 'cpf' é obrigatório");
        return false;
    }

    if(!Iemail.value.trim()) {
        exibirErro("O campo 'email' é obrigatório");
        return false;
    }

    if (!Isexo.value.trim()) {
        exibirErro("O campo 'Sexo' é obrigatório.");
        return false;
    }
    if (!Icep.value.trim()) {
        exibirErro("O campo 'CEP' é obrigatório.");
        return false;
    }

    if (!Iendereco.value.trim()) {
        exibirErro("O campo 'Endereço' é obrigatório.");
        return false;
    }

    if(!Inumero.value.trim() || isNaN(Inumero.value)) {
        exibirErro("O campo 'Número' é obrigatório e deve ser um valor numérico");
        return false;
    }

    return true;

}


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

    if(validarCampos()) {
        cadastrar();
        limpar();
    }
});