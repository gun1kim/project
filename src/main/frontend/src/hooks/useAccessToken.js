import {useContext} from "react";
import AccessTokenContext from "../context/AccessTokenContext";

const useAccessToken = () => {
    return useContext(AccessTokenContext);
}

export default useAccessToken;