import { useState } from "react";

export default function CadastroMateria(){
    const[nome, setNome] = useState('')
    const[nota1, setNota1] = useState(0)
    const[nota2, setNota2] = useState(0)
    const[nota3, setNota3] = useState(0)
    const[notafim, setNotafim] = useState(0)
    const[aluno, setAluno] = useState(0)
    const[status, setStatus] = useState('')

    function Salvar(){
        if (nome === ""){
            alert('Informe a matéria')
            return
        }

        var Materia = {aluno : Number(aluno) ,nome : nome, nota1 : nota1, nota2 : nota2, nota3 : nota3, notafim : notafim, status : status}

        fetch('http://localhost:8080/materias',
        {
            method: 'POST',
            headers: {'Content-Type':'application/json'},
            body: JSON.stringify(Materia)
        }).then(x=> alert('Matéria cadastrado ao aluno com sucesso!'))
    }
    return(
        <div className="conteiner">
            <h2 className="text-center">Nova Matéria</h2>

            <label className="form-label">Nome:</label>
            <input  type="text" onChange={nome => setNome(nome.target.value)}></input>

            <label className="form-label">1ª nota:</label>
            <input  type="number" onChange={nota1 => setNota1(nota1.target.value)}></input>
            
            <label className="form-label">2ª nota:</label>
            <input  type="number" onChange={nota2 => setNota2(nota2.target.value)}></input>

            <label className="form-label">3ª nota:</label>
            <input  type="number" onChange={nota3 => setNota3(nota3.target.value)}></input>

            <label className="form-label">Nota final:</label>
            <input  type="number" onChange={notafim => setNotafim(notafim.target.value)}></input>

            <label className="form-label">Aluno:</label>
            <input  type="number" onChange={aluno => setAluno(aluno.target.valueAsNumber)}></input>

            <label className="form-label">Status:</label>
            <input  type="text" onChange={status => setStatus(status.target.value)}></input>

            <div className="mt-3 d-flex justify-content-between">
                <button onClick={Salvar} className="btn btn-primary">Salvar nova Materia</button>
            </div>
        </div>
    )
}