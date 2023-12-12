import React, {useEffect, useState, useContext} from 'react';
import { BrowserRouter, Routes, Route }  from "react-router-dom";
import axios from 'axios';
import GatheringList from "./pages/gathering/GatheringList";
import GatheringDetail from "./pages/gathering/GatheringDetail";
import GatheringAdd from "./pages/gathering/GatheringAdd";
import GatheringUpdate from "./pages/gathering/GatheringUpdate";
import MissionList from './pages/mission/MissionList';
import MissionDetail from "./pages/mission/MissionDetail";
import Join from './pages/member/Join';
import Login from './pages/member/Login';
import { RecoilRoot } from 'recoil';
import { AccessTokenProvider } from './context/AccessTokenContext';

function App() {

    useEffect(() => {
        const savedToken = localStorage.getItem("login-token");
        if (savedToken) {
            axios.defaults.headers.common["Authorization"] = `Bearer ${savedToken}`;
        }
    }, []);

    
  return (
    <RecoilRoot>
      <BrowserRouter>
          <Routes>
              <Route path="/gathering" element={<GatheringList />}></Route>
              <Route path="/gathering/:gatheringId" element={<GatheringDetail />}></Route>
              <Route path="/gathering/add" element={<GatheringAdd />}></Route>
              <Route path="/gathering/update/:gatheringId" element={<GatheringUpdate />}></Route>
              <Route path="/mission" element={<MissionList />}></Route>
              <Route path="/mission-detail" element={<MissionDetail />}></Route>
              <Route path="/member/join" element={<Join />}></Route>
              <Route path="/member/login" element={<AccessTokenProvider><Login /></AccessTokenProvider>}></Route>

          </Routes>
      </BrowserRouter>
      </RecoilRoot>
  );
}

export default App;