import React from 'react';

import { Container, Links } from './style';

import logo from '../../assets/logo.png';

export default function Navbar() {
    return (
        <>
            <Container id="navbar">
                <img src={ logo } id="logo" alt="logo escrito octopus" width="200" />

                <Links>
                    <li><a href="#section1">Inicio</a></li>
                    <li><a href="#section2">Serviços</a></li>
                    <li><a href="#section3">Time</a></li>
                    <li><a href="#section4">Contato</a></li>
                </Links>
            </Container>
        </>
    )
}