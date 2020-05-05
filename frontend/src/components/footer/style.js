import styled from 'styled-components';

import WebFont from 'webfontloader';

WebFont.load({
  google: {
    families: ['Roboto', 'Open Sans', 'Asap Condensed']
  }
});

export const Links = styled.ul`
    margin-top:20px;

    a {
        margin:20px 10px 0 10px;
        font-family: 'Asap Condensed',sans-serif;
        color:white;
        text-decoration:none;
        font-size:18px;

        &:hover {
            color:#bdbdbd;
        }
    }
`;

export const Container = styled.div`
    height:30vh;
    background: #3651f8;

    display:flex;
    justify-content:center;
    align-items:center;
    flex-direction:column;
    
    img {
        width:200px;
    }
`;

export const Row = styled.hr`
    color: white;
    width: 8%;
    margin-top:20px;
`;

export const Copyright = styled.p`
    color:white;
    font-family: 'Open Sans',sans-serif;
`;

export const ContainerBottom = styled.div`
    display:flex;
    margin-top:10px;

    p {
        margin:0 2px;
        color:white;
        font-family: 'Open Sans',sans-serif;
    }
`;

export const Contact = styled.p`
    color:white;
    font-family: 'Open Sans',sans-serif;
`;

