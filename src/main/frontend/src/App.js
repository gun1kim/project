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
import MyMission from './pages/member/MyMission';
import MissionAdd from './pages/mission/MissionAdd';
import MissionModify from './pages/mission/MissionModify';
import MissionsUser from './pages/mission/MissionsUser';
import Missions from './pages/mission/Missions';
import '@coreui/coreui/dist/css/coreui.min.css';
import 'bootstrap/dist/css/bootstrap.min.css';

// import MemberContext from './context/MemberContext';
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
              <Route path="/missions" element={<MissionList />}></Route>
              <Route path="/missions/:missionId" element={<MissionDetail />}></Route>
              <Route path="/members/join" element={<Join />}></Route>
              <Route path="/members/login" element={<AccessTokenProvider><Login /></AccessTokenProvider>}></Route>
              <Route path="/mypage/missions" element={<MyMission />}></Route>
              <Route path="/missions/add" element={<MissionAdd />}></Route>
              <Route path="/missions/update" element={<MissionModify />}></Route>
              <Route path="/missions/members" element={<MissionsUser />}></Route>
              <Route path="admin/missions" element={<Missions />}></Route>
          </Routes>
      </BrowserRouter>
       </RecoilRoot>
  );
}

export default App;