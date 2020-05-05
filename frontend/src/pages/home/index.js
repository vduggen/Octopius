import React from 'react';

import Navbar from '../../components/navbar/index';
import Footer from '../../components/footer/index';

import { 
    Banner,
    Infos,
    ContainerSectionDivider, 
    Newsletter,
    Team,
    Support,
    Contact,
    Row
} from './style';

import FacebookMarketplace from '../../assets/facebookMarketplace.png';
import AmericanasMarketplace from '../../assets/americanas.png';
import MercadoLivreMarketplace from '../../assets/mercadolivre.png';
import SubmarinoMarketplace from '../../assets/submarino.png';
import ShoptimeMarketplace from '../../assets/shoptime.png';
import ZattiniMarketplace from '../../assets/zattini.jpg';
import Contato from '../../assets/contact.jpg';
import Raphael from '../../assets/raphael.png';
import Vitor from '../../assets/vitor.jpeg';
import Diego from '../../assets/diego.jpeg';
import Rodolfo from '../../assets/rodolfo.jpg';

import { MdAttachMoney } from 'react-icons/md';
import { GoLock } from 'react-icons/go';
import { FiFilter } from 'react-icons/fi';
import { RiMailSendLine } from 'react-icons/ri';
import { AiFillGithub } from 'react-icons/ai';
import { FaLinkedin } from 'react-icons/fa';

export default function Home() {
    onscroll = function() {
        if (window.scrollY > 534) { 
            document.getElementById('navbar').style.background = '#3651f8';
            document.getElementById('navbar').style.transition = 'all .1s';

        }else {
            document.getElementById('navbar').style.background = 'transparent';
            document.getElementById('navbar').style.transition = 'all .1s';
        }
    }

    return (
        <>
            <Navbar />

            <Banner id="section1">
                <div>
                    <h1>Bot para responder perguntas</h1>

                    <p>
                        Quer perder menos tempo lendo perguntas inuteis? Conheça agora mesmo 
                        octopius e pare de perder tempo lendo perguntas inuteis!
                    </p>
                </div>
            </Banner>

            {/* <ContainerSectionDivider>
                <img src={ ImageSectionDivider } alt="" />
            </ContainerSectionDivider> */}

            <Infos id="section2">
                <div id="esq">
                    <div>
                        <h1>Por que usar?</h1>

                        <p>
                            Lorem Ipsum is simply dummy text of the printing and typesetting industry. 
                            Lorem Ipsum has been the industry's standard dummy text ever since the 1500s,
                        </p>

                        <button>Ver Mais</button>
                    </div>
                </div>

                <div id="dir">
                    <div id="container">
                        <div id="first">
                            <div className="bg-icon">
                                <GoLock />
                            </div>

                            <div className="text">
                                <h2>Seguro</h2>
                                <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.</p>
                            </div>
                        </div>

                        <div id="secondary">
                            <div className="bg-icon">
                                <FiFilter />
                            </div>

                            <div className="text">
                                <h2>Filtragem</h2>
                                <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.</p>
                            </div>
                        </div>

                        <div id="three">
                            <div className="bg-icon">                            
                                <MdAttachMoney />
                            </div>

                            <div className="text">
                                <h2>Conversão</h2>
                                <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.</p>
                            </div>
                        </div>
                    </div>
                </div>
            </Infos>

            <Newsletter>
                <div id="containerNewsletter">
                    <h1>Fique por dentro das features do Octopius!</h1>
                    <p>Receba agora mesmo em seu E-mail todas features que sair sobre o Octopius!</p>

                    <div id="sendArea">
                        <input type="email" placeholder="Seu E-mail" required/>
                        <button type="submit">
                            <RiMailSendLine />
                        </button>
                    </div>
                </div>
            </Newsletter>

            <Team id="section3">
                <div id="title">
                    <h1>Time</h1>
                    <p>Conheça um pouco das pessoas que estão por trás do Octopius!</p>
                </div>

                <div id="cards">
                    <div className="card zoomCard">
                        <img src={ Vitor } />

                        <h1>Vitor Duggen</h1>
                        <p>Desenvolvedor Frontend</p>

                        <div className="redes-sociais">
                            <a href="www.github.com/vduggen">
                                <AiFillGithub />
                            </a>
                            
                            <a href="# ">
                                <FaLinkedin />
                            </a>
                        </div>
                    </div>
                    
                    <div className="card zoomCard">
                        <img src={ Diego } />

                        <h1>Diego A.</h1>
                        <p>Desenvolvedor Frontend & UX/UI</p>

                        <div className="redes-sociais">
                            <a href="# ">
                                <AiFillGithub />
                            </a>

                            <a href="# ">
                                <FaLinkedin />
                            </a>
                        </div>
                    </div>

                    <div className="card zoomCard">
                        <img src={ Rodolfo } />

                        <h1>Rodolfo Azevedo</h1>
                        <p>Desenvolvedor Backend</p>

                        <div className="redes-sociais">
                             <a href="# ">
                                <AiFillGithub />
                            </a>
                            
                            <a href="# ">
                                <FaLinkedin />
                            </a>
                        </div>
                    </div>

                    <div className="card zoomCard">
                        <img src={ Raphael } />

                        <h1>Raphael Martins</h1>
                        <p>Marketing</p>

                        <div className="redes-sociais">
                            <a href="# ">
                                <AiFillGithub />
                            </a>
                            
                            <a href="# ">
                                <FaLinkedin />
                            </a>
                        </div>
                    </div>
                </div>
            </Team>

            <Row />

            <Support>
                <div id="header-support">
                    <h1>Empresas que é possivel utilizar o Octopius</h1>
                    <p>Essas são alguma das empresas que você pode utilizar a ferramenta Octopius.</p>
                </div>

                <div className="container-cardSupport">
                    <div className="card-support">
                        <img src={ FacebookMarketplace } alt="" width="80" />

                        <div className="infos">
                            <h2>Facebook</h2>
                            <a href="# ">Ir para o Facebook Marketplace</a>                        
                        </div>
                    </div>

                    <div className="card-support">

                        <img src={ AmericanasMarketplace } alt="" width="80" />

                        <div className="infos">
                            <h2>Americanas</h2>
                            <a href="# ">Ir para a Americanas</a>                        
                        </div>
                    </div>
                    
                    <div className="card-support">

                        <img src={ MercadoLivreMarketplace } alt="" width="80" />

                        <div className="infos">
                            <h2>Mercado Livre</h2>
                            <a href="# ">Ir para o Mercado Livre</a>                        
                        </div>
                    </div>
                </div>

                <div className="container-cardSupport">
                    <div className="card-support">

                        <img src={ ZattiniMarketplace } alt="" width="80" />

                        <div className="infos">
                            <h2>Zattini</h2>
                            <a href="# ">Ir para a Zattini</a>                        
                        </div>
                    </div>

                    <div className="card-support">

                        <img src={ SubmarinoMarketplace } alt="" width="80" />

                        <div className="infos">
                            <h2>Submarino</h2>
                            <a href="# ">Ir para o Submarino</a>                        
                        </div>
                    </div>
                    
                    <div className="card-support">

                        <img src={ ShoptimeMarketplace } alt="" width="80" />

                        <div className="infos">
                            <h2>Shoptime</h2>
                            <a href="# ">Ir para o Shoptime</a>                        
                        </div>
                    </div>
                </div>
            </Support>

            <Row />

            <Contact id="section4">
                <div id="dir-contact">
                    <h1>Contato</h1>

                    <div id="containerInputsTop">
                        <div id="NameArea">
                            <label for="nameComplete">Nome:</label>
                            <input type="text" id="nameComplete" placeholder="Digite seu nome completo"/>
                        </div>

                        <div id="EmailArea">
                            <label for="email">E-mail:</label>
                            <input type="email" id="email" placeholder="Digite seu E-mail"/>
                        </div>
                    </div>
                    
                    <div id="AssuntoArea">
                        <label for="assunto">Assunto:</label>
                        <input type="text" id="assunto" placeholder="Digite o assunto"/>
                    </div>

                    <div id="MensagemArea">
                        <label for="mensagem">Mensagem:</label>
                        <textarea id="Mensagem" rows="7"></textarea>
                    </div>

                    <button type="submit">Enviar Mensagem</button>
                </div>
            </Contact>

            <Footer />
        </>
    )
}