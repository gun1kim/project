import {createContext, useState} from "react";

const AccessTokenContext = createContext({});

export const AccessTokenProvider = ({children}) => {
    const [accessToken, setAccessToken] = useState({});

    return (
        <AccessTokenContext.Provider value={{accessToken, setAccessToken}}>
            {children}
        </AccessTokenContext.Provider>
    )
}

export default AccessTokenContext;