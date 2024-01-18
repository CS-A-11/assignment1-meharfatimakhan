disp('Solution of N-equation "[A][X]=[r]"')
n=input ('Enter number of Equations :');
A=input ('Enter Augmented Matrix [A]:');

for i=1:n-1  %loop to perform the gauss elimination
    for k=i+1:n
        t=(A(k,i)/A(i,i));
        for j=1:n+1
            A(k,j)=A(k,j)-(t*A(i,j));%make the elements below the diagonal 
        end                          %equal to zero or elimnate the variables
    end
end
disp('Upper riangular Matrix (AUGMENTED) =');disp(A)


x(n)=A(n,n+1)/A(n,n);
for i=n-1:-1:1  %back-substitution
    sum=0;
    for j=i+1:n 
        sum=sum+A(i,j)*x(j);
    end
    x(i)=(1/A(i,i))*(A(i,n+1)-sum);
end

 disp('Solution of Linear Equations :');disp(x)

