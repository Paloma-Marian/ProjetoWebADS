import { useState } from "react";

export default function CadastroAluno(){
    const[nome, setNome] = useState('')

    function Salvar(){
        if (nome === ""){
            alert('Informe um sabor')
            return
        }
        let Aluno = {nome}

        fetch('http://localhost:8080/alunos',
        {
            method: 'POST',
            headers: {'Content-Type':'application/json'},
            body: JSON.stringify(Aluno)
        }).then(x=> alert('Aluno cadastrado com sucesso!'))
    }
}