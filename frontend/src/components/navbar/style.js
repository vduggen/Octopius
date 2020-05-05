import styled from 'styled-components';
import WebFont from 'webfontloader';

WebFont.load({
  google: {
    families: ['Roboto', 'Open Sans']
  }
});

export const Container = styled.div`
    height:50px;
    position:fixed;
    top:0;
    min-width:84%;
    width:auto;
    padding:0 5%;
    background-color:transparent;
    padding:15px 8%;
    z-index:2;

    display:flex;
    align-items:center;
    justify-content:space-between;
`;

export const Links = styled.ul`
    display:flex;
    align-items:center;

    a {
        margin:0 20px;
        color:#fff;
        font-family:'Roboto',sans-serif;
        text-decoration:none;

        &:hover {
            color:#bdbdbd;
        }
    }
`;