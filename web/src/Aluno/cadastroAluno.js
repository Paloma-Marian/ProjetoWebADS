import { useState } from "react";

export default function CadastroAluno(){
    const[nome, setNome] = useState('');
    const[cpf, setCpf] = useState('');
    const[email, setEmail] = useState('');
    const[status, setStatus] = useState('');

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
        }).then(aluno=> alert('Aluno cadastrado com sucesso!'))
    }
    return(
        <div className="container">
            <h2 className="text-center">Novo Aluno</h2>

            <div class="input-group input-group-sm mb-3">
                <span class="input-group-text" id="inputGroup-sizing-default">Nome:</span>
                <input 
                    type="text" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default" placeholder="Nome" 
                    onChange={nome => setNome(nome.target.value)}>
                </input>   

                <span class="input-group-text" id="inputGroup-sizing-default">CPF:</span>
                <input 
                    type="text" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default" placeholder="000.000.000-00" 
                    onChange={cpf => setCpf(cpf.target.value)}>
                </input>

                <span class="input-group-text" id="inputGroup-sizing-default">@:</span>
                <input 
                    type="text" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default" placeholder="nome@example.com" 
                    onChange={email => setEmail(email.target.value)}>
                </input>

                <span class="input-group-text" id="inputGroup-sizing-default">Status:</span>
                <input 
                    type="text" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default" placeholder="ATIVO" 
                    onChange={status => setStatus(status.target.value)}>
                </input>
            </div>

            <div className="d-grid gap-2 col-6 mx-auto">
                <button onClick={Salvar} className="btn btn-outline-primary fw-bold">Salvar novo Aluno</button>
            </div>
        </div>
    )
}