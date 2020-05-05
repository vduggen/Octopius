import styled from 'styled-components';
import bg from '../../assets/bg3.jpg';
import WebFont from 'webfontloader';

WebFont.load({
  google: {
    families: ['Roboto', 'Open Sans', 'Asap Condensed']
  }
});

export const Banner = styled.section`
    background-image: url(${bg});
    background-position:top;
    background-size:cover;
    height:100vh;
    box-shadow: 0 0 14px #333;

    display: grid;
    grid-template-columns: 1fr 1fr;
    grid-template-rows: 100vh;

    div {
        width:68%;
        margin:0 auto;
        display: flex;
        flex-direction: column;
        justify-content: center;
        z-index:1;
        margin-top:-34px;

        h1 {
            font:bold 55px 'Asap Condensed',sans-serif;
            color:white;
            width:120%;
            text-transform:capitalize;
        }

        p {            
            margin: 10px 0 25px 0;
            color: #e8e8e8;
            font-family: 'Open Sans',sans-serif;
            line-height: 20px;
        }

        div {
            width: 100%;
            display: grid;
            grid-template-columns: repeat(2,50%);
            margin: 0 auto;

            button {
                &:first-child {
                    border: 1px solid #18749e;
                    padding: 9px 28px;
                    border-radius: 50px;
                    background: transparent;
                    color: #18749e;
                    font-weight: bold;
                    font-size: 16px;
                    margin-right: 5px;
                }

                &:last-child {
                    border: none;
                    padding: 9px 28px;
                    border-radius: 50px;
                    background: #18749e;
                    color: white;
                    font-weight: bold;
                    font-size: 16px;
                }
            }
        }
    }
`;

export const ContainerSectionDivider = styled.section`
    img {
        width:100%;
        position:absolute;
        top:27%;
        z-index:0;
    }
`;

export const Infos = styled.section`
    height:91vh;

    display:grid;
    grid-template-columns:1fr 1fr;
    grid-template-rows:auto;

    #esq {       
        display: flex;
        align-items: center;
        justify-content:center;
        flex-direction:column;

        div {
            width:57%;

            display: flex;
            align-items: flex-start;
            justify-content:center;
            flex-direction:column;
        }

        h1 { 
            font: bold 47px 'Asap Condensed',sans-serif;
            text-transform:capitalize;
            color:#3651f8;
        }

        p {
            margin: 20px 0 20px 0;
            font:normal 18px 'Open Sans',sans-serif;
            color:#8a8a8a;
            line-height:32px;
        }

        button {
            border:none;
            padding:12px 50px;
            border-radius:50px;
            background-color:#3651f8;
            color:#fff;
            font-weight:bold;
        }
    }

    #dir {
        display: flex;
        align-items: flex-start;
        justify-content:center;
        flex-direction:column;

        #container {
            width:68%;

            display:flex;
            justify-content:flex-start;
            align-items:flex-start;
            flex-direction:column;

            div {
                margin:15px 0;

                display:flex;
                align-items:center;                
                
                .bg-icon {
                        background: #3651f8c2;
                        padding:22px;
                        margin-right:30px;
                        border-radius: 50px;

                    svg {
                        font-size:30px;
                        color:white;
                    }
                }
                
                .text {
                    display:flex;
                    flex-direction:column;
                    align-items:flex-start;
                    font-size:18px;

                    h2 {
                        font:normal 23px 'Asap Condensed',sans-serif;
                        color:#3651f8;
                    }

                    p {
                        font:normal 11pt 'Open Sans',sans-serif;
                        color:#8a8a8a;
                    }
                }
            }
        }
    }
`;

export const Newsletter = styled.div`
    height:30vh;
    width:100%;
    background: #3651f8;
    text-align:center;
    box-shadow: 1px 1px 11px #333;

    display:flex;
    align-items:center;
    justify-content:center;
    flex-direction:column;

    #containerNewsletter {
        h1 {
            font:bold 45px 'Asap Condensed',sans-serif;        
            color:#fff;
        }
        
        p {
            font:normal 18px 'Open Sans',sans-serif;
            color:#fff;
        }

        #sendArea {
            margin-top:20px;
            position:relative;

            
            input {
                border:none;
                padding:8px 0 8px 15px ;
                border-radius:50px;
                width:76%;
                position:relative;
            }

            button {
                height: 89%;
                border:none;
                background:#3651f8;
                border-radius:50px;
                color: #fff;
                font-size: 20px;

                position: absolute;
                right: 84px;
                top: 5%;

                display: flex;
                justify-content: center;
                align-items: center;
            }
        }
    }
`;

export const Team = styled.section`
    height:88vh;

    display: flex;
    flex-direction: column;
    justify-content: center;

    #title {
        margin-bottom:54px;

        display:flex;
        align-items:center;
        flex-direction:column;

        h1 {
            font: bold 47px 'Asap Condensed',sans-serif;
            color:#3651f8;
        }

        p {
            font:normal 18px 'Open Sans',sans-serif;
            color:#8a8a8a;
        }
    }    

    #cards {
        display: flex;
        justify-content: center;     

        .card {
            background:#fff;
            box-shadow: 0 0 14px #33333336;
            width:184px;
            padding:44px 35px;
            border-radius:3%;
            margin:0 20px;
            -moz-transition: all 0.3s;
            -webkit-transition: all 0.3s;
            transition: all 0.3s;

            display:flex;
            align-items:center;
            flex-direction:column;

            &:hover {
                -moz-transform: scale(1.1);
                -webkit-transform: scale(1.1);
                transform: scale(1.1);
                box-shadow: 0 0 14px #333333b3;
            }         

            img {
                width:110px;
                border-radius:50%;
                box-shadow:0 0 14px #33333394;
            }

            h1 {
                margin-top:8px;
                font: bold 20px 'Asap Condensed',sans-serif;
                color:#3651f8;
            }

            p {
                font:normal 15px 'Open Sans',sans-serif;
                color:#8a8a8a;
            }

            .redes-sociais {
                font-size:26px;
                margin-top:20px;

                a:first-child {
                    color:#333;
                    margin-right:5px;
                }

                a:last-child {
                    color: #0E76A8;
                    margin-left:5px;
                }
            }
        }
    }    
`;

export const Row = styled.hr`
    width:65%;
    height:1px;
    margin:0 auto;
    background-color: gray;
    border:none;
`;

export const Support = styled.section`
    height:89vh;

    display: flex;
    justify-content: center;
    flex-direction: column;

    #header-support {
        text-align:center;
        margin-bottom:34px;

        h1 {
            font: bold 47px 'Asap Condensed',sans-serif;
            color:#3651f8;
        }

        p {
            font:normal 18px 'Open Sans',sans-serif;
            color:#8a8a8a;
        }
    }

    .container-cardSupport { 
        display: flex;
        justify-content: center; 

        &:last-child {
            margin-top:15px;
        }
        
        .card-support {
            margin:0 20px;
            text-align:center;
            min-width: 21%;

            img {
                border-radius:50%;
                box-shadow: 0 0 14px #33333336;
            }
            
            .infos {
                margin-top:10px;
                background: #fff;
                box-shadow: 0 0 14px #33333336;
                margin: -37px 0 0 0;
                padding: 43px 45px 21px 45px;
                border-radius:3%;                

                h2 {
                    font: bold 20px 'Asap Condensed',sans-serif;
                    color:#3651f8;
                }

                a {
                    text-decoration:none;
                    font:normal 15px 'Open Sans',sans-serif;
                    color:#8a8a8a;
                }
            }
        }
    }
`;

export const Contact = styled.section`
    height:76vh;

    #dir-contact {
        width:65%;

        display:flex;
        justify-content:center;
        align-items:center;
        flex-direction:column;
        margin:0 auto;
        margin-top:50px;

        h1 {
            font: bold 47px 'Asap Condensed',sans-serif;
            color:#3651f8;
            margin-bottom:30px;
        }

        #NameArea, #EmailArea, #AssuntoArea, #MensagemArea {
            display:flex;
            flex-direction:column;

            input,textarea {
                border-radius:8px;
                border:none;
                border: 1px solid #ccc; 
                padding:10px 0 10px 20px;
                resize:none;
            }
        }

        label {
            margin-bottom:5px;
            font-family:'Open Sans', sans-serif;
        }

        #containerInputsTop {
            width:100%;

            display:grid;
            grid-template-columns: 1fr 1fr;
            grid-column-gap: 5%;
        }

        #AssuntoArea, #MensagemArea {
            width:100%;
            margin-top:20px;
        }

        button {
            width:100%;
            margin-top:20px;
            background:#3651f8;
            border:none;
            padding:10px 0;
            border-radius:50px;
            transition: all .4s;

            color:white;
            font-weight:bold;
            font-size:18px;
            font-family: 'Asap Condensed',sans-serif;

            &:hover {
                background: #3f8df2;
            }
        }
    }
`;