import { useState } from 'react';
import { useParams } from 'react-router-dom'

export default function AlterarAluno(){
    const[nome, setNome] = useState('');
    const[cpf, setCpf] = useState('');
    const[email, setEmail] = useState('');
    const[status, setStatus] = useState('');
    const{id_aluno} = useParams();

    function Salvar(){
        if (nome === "") {
            alert('Informe o nome do aluno!')
            return
        }

        let Aluno = {id: id_aluno, nome, cpf, email, status}

        fetch(`http://localhost:8080/alunos/${id_aluno}`,
        {
            method: 'PUT',
            headers: {'Content-Type':'application/json'},
            body: JSON.stringify(Aluno)
        }).then(aluno=> alert('Aluno alterado com sucesso!'))
    }

    useState(() => {
        fetch(`http://localhost:8080/alunos/${id_aluno}`)
        .then(data => data.json())
        .then(aluno_aux => {
            setNome(aluno_aux.nome)
            setCpf(aluno_aux.cpf)
            setEmail(aluno_aux.email)
            setStatus(aluno_aux.status)
        })
    },[])

    return(
        <div className="container">
            <h2 className="text-center">Alterar Aluno</h2>

            <div class="input-group input-group-sm mb-3">
                <span class="input-group-text" id="inputGroup-sizing-default">Nome:</span>
                <input 
                    type="text" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default" placeholder="Nome" 
                    value={nome} onChange={nome => setNome(nome.target.value)}>
                </input>   

                <span class="input-group-text" id="inputGroup-sizing-default">CPF:</span>
                <input 
                    type="text" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default" placeholder="000.000.000-00" 
                    value={cpf} onChange={cpf => setCpf(cpf.target.value)}>
                </input>

                <span class="input-group-text" id="inputGroup-sizing-default">@:</span>
                <input 
                    type="text" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default" placeholder="nome@example.com" 
                    value={email} onChange={email => setEmail(email.target.value)}>
                </input>

                <span class="input-group-text" id="inputGroup-sizing-default">Status:</span>
                <input 
                    type="text" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default" placeholder="ATIVO" 
                    value={status} onChange={status => setStatus(status.target.value)}>
                </input>
            </div>

            <div className="d-grid gap-2 col-6 mx-auto">
                <button onClick={Salvar} className="btn btn-outline-primary fw-bold">Salvar novo Aluno</button>
            </div>
        </div>
    )
}