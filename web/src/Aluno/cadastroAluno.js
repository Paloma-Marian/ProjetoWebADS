import { useState } from "react";

export default function CadastroAluno(){
    const[nome, setNome] = useState('')
    const[cpf, setCpf] = useState('')
    const[email, setEmail] = useState('')
    const[status, setStatus] = useState('')

    function Salvar(){
        if (nome === ""){
            alert('Informe o nome')
            return
        }
        let Aluno = {nome, cpf, email, status}

        fetch('http://localhost:8080/alunos',
        {
            method: 'POST',
            headers: {'Content-Type':'application/json'},
            body: JSON.stringify(Aluno)
        }).then(x=> alert('Aluno cadastrado com sucesso!'))
    }
    return(
        <div className="conteiner">
            <h2 className="text-center">Novo Aluno</h2>

            <label className="form-label">Informe o Nome:</label>
            <input  type="text" onChange={nome => setNome(nome.target.value)}></input>

            <label className="form-label">Informe o CPF:</label>
            <input  type="text" onChange={cpf => setCpf(cpf.target.value)}></input>
            
            <label className="form-label">Informe o Email:</label>
            <input  type="text" onChange={email => setEmail(email.target.value)}></input>

            <label className="form-label">Informe o status:</label>
            <input  type="text" onChange={status => setStatus(status.target.value)}></input>

            <div className="mt-3 d-flex justify-content-between">
                <button onClick={Salvar} className="btn btn-primary">Salvar novo Aluno</button>
            </div>
        </div>
    )
}