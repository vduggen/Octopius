import React from 'react';

import logo from '../../assets/logo.png';

import { 
    Links,
    Container,
    Row,
    Copyright,
    ContainerBottom,
    Contact
} from './style';

import { Link } from 'react-router-dom';

export default function Footer() {
    return (
        <>
            <Container>
                <img src={ logo } alt="logo" />

                <Links>
                    <Link to="/">Inicio</Link>
                    <Link to="/">Serviços</Link>
                    <Link to="/">Review</Link>
                    <Link to="/">Contato</Link>
                </Links>

                <Row />

                <ContainerBottom>
                    <Copyright>
                        &copy; 2020 Octopius
                    </Copyright>                
                    
                    <p>–</p>

                    <Contact>
                        
                        octopius@contact.com
                    </Contact>
                </ContainerBottom>
            </Container>
        </>
    )
}