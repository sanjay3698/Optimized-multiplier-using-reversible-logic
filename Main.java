module pg (a,b,c,p,q,r);
  input  a,b,c;
  output  p,q,r;
  assign p=a;
  assign q=a^b;
  assign r=((a&b)^c);
endmodule


module tg (a,b,c,p,q,r);
  input  a,b,c;
  output  p,q,r;
  assign p=a;
  assign q=b;
  assign r=(a&b)^c;
endmodule


module dpg (a,b,c,d,p,q,r,s);
  output  p,q,r,s;
  input  a,b,c,d;
  assign p=a;
  assign q=a^b;
  assign r=a^b^c;
  assign s=(a^b)&c^a&b;
endmodule




module first(a,c);
  input a;
  output c;
  assign c= a;
endmodule



module produt(x,y,g,p);
input [3:0]x,y;
wire [15:0]z;
output [28:0]g;
wire [41:1]w;
output [7:0]p;

assign v=0;


//wire [40:1]w;
tg t1(x[0],y[0],v,w[1],w[4],z[0]);
tg t2(w[1],y[1],v,w[2],w[5],z[1]);
tg t3(w[2],y[2],v,w[3],w[6],z[2]);
tg t4(y[3],w[3],v,w[7],g[0],z[3]);
tg t5(x[1],w[4],v,w[8],w[11],z[4]);
tg t6(w[8],w[5],v,w[9],w[12],z[5]);
tg t7(w[9],w[6],v,w[10],w[13],z[6]);
tg t8(w[7],w[10],v,w[14],g[1],z[7]);
tg t9(x[2],w[11],v,w[15],w[18],z[8]);
tg t10(w[15],w[12],v,w[16],w[19],z[9]);
tg t11(w[16],w[13],v,w[17],w[20],z[10]);
tg t12(w[14],w[17],v,w[21],g[2],z[11]);
pg p1 (x[3],w[18],v,w[22],g[3],z[12]);
pg p2 (w[22],w[19],v,w[23],g[4],z[13]);
pg p3 (w[23],w[20],v,w[24],g[5],z[14]);
pg p4 (w[21],w[24],v,g[7],g[8],z[15]);
first f1(z[1],p[0]);
pg p5(z[1],z[4],v,g[9],p[1],w[25]);
dpg h1(z[8],z[5],z[2],v,g[10],g[11],w[26],w[27]);
dpg h2(z[12],z[9],z[6],v,g[12],g[13],w[28],w[29]);
pg p6(z[13],z[10],v,g[14],w[30],w[31]);
pg p7(w[25],w[26],v,g[15],p[2],w[32]);
dpg h3(z[3],w[27],w[28],v,g[16],g[17],w[33],w[34]);
dpg h4(z[7],w[29],w[30],v,g[18],g[19],w[35],w[36]);
dpg h5(z[11],w[31],z[14],v,g[20],g[21],w[37],w[38]);
pg p8(w[32],w[33],v,g[22],p[3],w[39]);
dpg h6(w[39],w[34],w[35],v,g[23],g[24],p[4],w[40]);
dpg h7(w[40],w[36],w[37],v,g[25],g[26],p[5],w[41]);
dpg h8(w[41],w[38],z[15],v,g[27],g[28],p[6],p[7]);
endmodule
