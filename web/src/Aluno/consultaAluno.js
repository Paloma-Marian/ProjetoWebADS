import { useEffect, useState } from 'react';
import BuscaAluno from './buscaAluno';

export default function ConsultarAluno(){
    const [alunos, setAlunos] = useState([]);

    function buscaAlunos() {
        fetch("http://localhost:8080/alunos")
        .then(data => data.json())
        .then(response => setAlunos(response))
    } useEffect(buscaAlunos, [])

    return(
        <div>
            <h2>Consulta de Alunos</h2>
            <div className='d-flex flex-wrap'>
                {
                    alunos.map(aluno => <BuscaAluno aluno={aluno}/>)
                }
            </div>
        </div>
    )
}