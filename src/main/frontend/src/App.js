import React, {useEffect, useState} from 'react';
import { BrowserRouter, Routes, Route }  from "react-router-dom";
import axios from 'axios';
import GatheringList from "./GatheringList";

function App() {
  // const [hello, setHello] = useState('')
  //
  // useEffect(() => {
  //   axios.get('/api/hello')
  //       .then(response => setHello(response.data))
  //       .catch(error => console.log(error))
  // }, []);

  return (
      <BrowserRouter>
          <Routes>
              <Route path="/" element={<GatheringList />}></Route>
          </Routes>
      </BrowserRouter>
      // <div>
      //   백엔드에서 가져온 데이터입니다 : {hello}
      // </div>
  );
}

export default App;