import React from "react";
import axios from "axios";
import { useNavigate } from "react-router-dom";
function LogoutButton() {
    const navigate = useNavigate();
    const logout = () => {
        const accessToken = localStorage.getItem('access-token')
        const refreshToken = localStorage.getItem('refresh-token');
        axios.delete('http://localhost:8080/api/member/logout', {
            headers: {
                Authorization: `Bearer ${accessToken}`,
                'x-refresh-token': refreshToken
            }
        })
        .then(response => {
            console.log('리프레시 토큰 삭제 성공');
        })
        .catch(error => {
            console.log('리프레시 토큰 삭제 실패');
            console.log(error);
        })
        localStorage.removeItem('access-token');
        localStorage.removeItem('refresh-token');
        localStorage.removeItem('memberId');
        // window.location.href="/member/login";
        navigate("/member/login");
        

    }
    
    return ( 
        <button onClick={logout}>
            Logout
        </button>
    )
}

export default LogoutButton;